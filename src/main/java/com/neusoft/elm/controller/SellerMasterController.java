package com.neusoft.elm.controller;

import com.neusoft.elm.dataobject.OrderMaster;
import com.neusoft.elm.enums.ResultEnum;
import com.neusoft.elm.exception.SellException;
import com.neusoft.elm.services.OrderMasterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author QiutianDog
 * @Date 2020/12/3
 */
@Controller
@RequestMapping("/seller/master")
public class SellerMasterController {

    @Autowired
    OrderMasterServices services;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<OrderMaster> list = services.findAll();
        map.put("masterList", list);
        return new ModelAndView("seller/master/list", map);
    }

    @GetMapping("/done")
    public ModelAndView done(@RequestParam String orderId, Map<String, Object> map) {
        try{
            services.done(orderId);
        }catch (SellException e) {
            map.put("url", "/seller/master/list");
            map.put("msg", ResultEnum.ORDER_STATUS_ERROR);
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/master/list");
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS);
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/del")
    public ModelAndView del(@RequestParam String orderId, Map<String, Object> map) {
        try{
            services.remove(orderId);
        }catch (SellException e) {
            map.put("url", "/seller/master/list");
            map.put("msg", ResultEnum.SUCCESS);
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/master/list");
        map.put("msg", ResultEnum.ORDER_STATUS_ERROR);
        return new ModelAndView("common/success", map);
    }
}
