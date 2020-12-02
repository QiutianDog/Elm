package com.neusoft.elm.controller;

import com.neusoft.elm.dataobject.BuyerUser;
import com.neusoft.elm.dataobject.OrderDetail;
import com.neusoft.elm.dataobject.OrderMaster;
import com.neusoft.elm.dataobject.ProductInfo;
import com.neusoft.elm.enums.OrderStatusEnum;
import com.neusoft.elm.enums.PayStatusEnum;
import com.neusoft.elm.enums.ResultEnum;
import com.neusoft.elm.exception.SellException;
import com.neusoft.elm.from.OrderFrom;
import com.neusoft.elm.services.BuyerServices;
import com.neusoft.elm.services.OrderDetailServices;
import com.neusoft.elm.services.OrderMasterServices;
import com.neusoft.elm.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
@Controller()
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerServices buyerServices;

    @Autowired
    ProductServices productServices;

    @Autowired
    OrderDetailServices detailServices;

    @Autowired
    OrderMasterServices masterServices;

    @GetMapping("/")
    public ModelAndView index() {
        // 首页 注册和登录
        return new ModelAndView("buyer/index");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("buyer/login");
    }

    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest request
            , Map<String, Object> map) {
        BuyerUser login = buyerServices.login(request.getParameter("buyerName")
                , request.getParameter("buyerPassword"));
        if (login != null) {
            map.put("msg", "ok");
            map.put("url", "/buyer/user?buyerId="+login.getBuyerId());
            return new ModelAndView("common/success");
        }
        map.put("msg", "error");
        map.put("url", "/buyer/login");
        return new ModelAndView("common/error");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("buyer/register");
    }

    @PostMapping("/register")
    public ModelAndView register(HttpServletRequest request
            , Map<String, Object> map) {
        BuyerUser buyer = new BuyerUser();

        buyer.setBuyerName(request.getParameter("buyer-name"));
        buyer.setBuyerPassword(request.getParameter("buyer-password"));
        buyer.setBuyerPhoneNumber(request.getParameter("buyer-phone"));
        buyer.setWechatId(request.getParameter("wechat"));
        buyer.setBuyerMoney(new BigDecimal(request.getParameter("buyer-money")));
        buyer.setBuyerAddress(request.getParameter("buyerAddress"));
        BuyerUser buyerUser = buyerServices.save(buyer);
        if (buyerUser != null) {
            map.put("url", "/buyer/user?buyerId=" + buyerUser.getBuyerId());
            map.put("msg", "ok");
            return new ModelAndView("common/success", map);
        }

        map.put("url", "/buyer/register");
        map.put("msg", "error");
        return new ModelAndView("common/error", map);
    }

    @GetMapping("/user")
    public ModelAndView user(@RequestParam String buyerId
            , Map<String, Object> map) {
        // 用户界面

        BuyerUser buyer = buyerServices.findById(buyerId);
        List<ProductInfo> upAll = productServices.findUpAll();
        map.put("buyer", buyer);
        map.put("productList", upAll);
        return new ModelAndView("buyer/user", map);
    }

    @GetMapping("/list")
    public ModelAndView list(@RequestParam String buyerId
            , Map<String, Object> map) {
        List<ProductInfo> upAll = productServices.findUpAll();
        map.put("productList", upAll);
        map.put("buyerId", buyerId);
        return new ModelAndView("buyer/list", map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(Map<String, Object> map) {
        List<OrderFrom> list = new ArrayList<>();
        List<OrderDetail> detailList = detailServices.findAll();
        for (OrderDetail orderDetail : detailList) {
            OrderFrom from = new OrderFrom();
            OrderMaster master = masterServices.findByOrderId(orderDetail.getOrderId());
            from.setOrderId(orderDetail.getOrderId());
            from.setProductName(orderDetail.getProductName());
            from.setProductIcon(orderDetail.getProductIcon());
            from.setProductPrice(orderDetail.getProductPrice());
            from.setProductQuantity(orderDetail.getProductQuantity());
            from.setPayStatus(master.getPayStatus());
            from.setOrderStatus(master.getOrderStatus());
            from.setCreateTime(master.getCreateTime());
            from.setUpdateTime(master.getUpdateTime());
            list.add(from);
        }
        map.put("fromList", list);
        return new ModelAndView("buyer/detail", map);
    }

    @GetMapping("/order")
    public ModelAndView order(@RequestParam String productId
            , @RequestParam String buyerId
            , Map<String, Object> map) {
        ProductInfo product = productServices.findOne(productId);
        map.put("product", product);
        map.put("buyerId", buyerId);
        return new ModelAndView("buyer/order", map);
    }

    @PostMapping("/order")
    public ModelAndView order(HttpServletRequest request
            , Map<String, Object> map) {
        ProductInfo product = productServices.findOne(request.getParameter("productId"));
        BuyerUser buyer = buyerServices.findById(request.getParameter("buyerId"));
        String productQuantity = request.getParameter("productQuantity");
        // 判断是否可以创建
        if (product.getProductStock() - Integer.valueOf(productQuantity) >= 0) {
            product.setProductStock(product.getProductStock() - Integer.valueOf(productQuantity));
            productServices.save(product);

            // 开始创建订单
            OrderMaster master = new OrderMaster();
            master.setBuyerName(buyer.getBuyerName());
            master.setBuyerPhone(buyer.getBuyerPhoneNumber());
            master.setBuyerAddress(buyer.getBuyerAddress());
            master.setBuyerOpenid(buyer.getWechatId());
            master.setOrderAmount(new BigDecimal(productQuantity).multiply(product.getProductPrice()));
            masterServices.save(master);

            OrderDetail detail = new OrderDetail();
            detail.setOrderId(master.getOrderId());
            detail.setBuyerId(buyer.getBuyerId());
            detail.setProductId(product.getProductId());
            detail.setProductName(product.getProductName());
            detail.setProductPrice(product.getProductPrice());
            detail.setProductQuantity(Integer.valueOf(productQuantity));
            detail.setProductIcon(product.getProductIcon());
            detailServices.save(detail);
            map.put("url", "/buyer/detail");
            map.put("msg", ResultEnum.SUCCESS);
            return new ModelAndView("common/success", map);
        }
        map.put("url", "/buyer/detail");
        map.put("msg", ResultEnum.PARAM_ERROR);
        return new ModelAndView("common/error", map);
    }

    @GetMapping("/pay")
    public ModelAndView pay(@RequestParam String orderId
            , Map<String, Object> map) {
        OrderMaster master = masterServices.findByOrderId(orderId);
        OrderDetail detail = detailServices.findById(orderId);
        BuyerUser buyer = buyerServices.findById(detail.getBuyerId());
        BigDecimal need = master.getOrderAmount();
        BigDecimal money = buyer.getBuyerMoney();
        if (money.subtract(need).doubleValue() >= 0
                && master.getPayStatus().equals(PayStatusEnum.WAIT.getCode())
                && master.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            // 钱够 就付钱
            buyer.setBuyerMoney(money.subtract(need));
            buyerServices.save(buyer);

            masterServices.pay(master.getOrderId());
            map.put("url", "/buyer/detail");
            map.put("msg", ResultEnum.SUCCESS);
            return new ModelAndView("common/success");
        }

        map.put("url", "/buyer/detail");
        map.put("msg", ResultEnum.ORDER_PAY_STATUS_ERROR);
        return new ModelAndView("common/error", map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam String orderId
            , Map<String, Object> map) {
        OrderMaster master = masterServices.findByOrderId(orderId);
        if (master.getPayStatus().equals(PayStatusEnum.WAIT.getCode())
            && master.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            OrderDetail detail = detailServices.findById(orderId);
            for (int i = 0; i < detail.getProductQuantity(); i++) {
                productServices.increaseStock(detail.getProductId());
            }
            masterServices.cancel(orderId);
            map.put("url", "/buyer/detail");
            map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS);
            return new ModelAndView("common/success");
        }

        map.put("url", "/buyer/detail");
        map.put("msg", ResultEnum.ORDER_STATUS_ERROR);
        return new ModelAndView("common/error", map);
    }

}
