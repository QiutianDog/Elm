package com.neusoft.elm.controller;

import com.neusoft.elm.dataobject.ProductCategory;
import com.neusoft.elm.dataobject.ProductInfo;
import com.neusoft.elm.enums.ResultEnum;
import com.neusoft.elm.exception.SellException;
import com.neusoft.elm.services.CategoryServices;
import com.neusoft.elm.services.ProductServices;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author QiutianDog
 * @Date 2020/11/27
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductServices productServices;

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/list")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer pageNumber
            , @RequestParam(defaultValue = "5") Integer pageSize
            , Map<String, Object> map) {
        PageRequest of = PageRequest.of(pageNumber - 1, pageSize);
        Page<ProductInfo> pages = productServices.findAll(of);
        map.put("productList", pages);
        map.put("pageNumber", pageNumber);
        map.put("pageSize", pageSize);
        return new ModelAndView("product/list", map);
    }


    @RequestMapping("/index")
    public ModelAndView save(@RequestParam(required = false) String productId
            , Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            // 修改操作
            ProductInfo one = productServices.findOne(productId);
            ProductCategory category = categoryServices.findByCategoryType(one.getCategoryType());
            map.put("product", one);
            map.put("category", category);
        }
        List<ProductCategory> categoryList = categoryServices.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index", map);
    }


    @PostMapping("/save")
    public ModelAndView save(HttpServletRequest request, Map<String, Object> map) {
        ProductInfo productInfo = new ProductInfo();
        try{
            productInfo.setProductId(request.getParameter("productId"));
            productInfo.setProductName(request.getParameter("productName"));
            productInfo.setProductPrice(new BigDecimal(request.getParameter("productPrice")));
            productInfo.setProductStock(Integer.valueOf(request.getParameter("productStock")));
            productInfo.setProductDescription(request.getParameter("productDescription"));
            productInfo.setProductIcon(request.getParameter("productIcon"));

            System.out.println(request.getParameter("productIcon"));

            if (!StringUtils.isEmpty(request.getParameter("productStatus"))) {
                productInfo.setProductStatus(0);
            } else {
                productInfo.setProductStatus(1);
            }
            productInfo.setCategoryType(Integer.valueOf(request.getParameter("categoryType")));
            productServices.save(productInfo);
        } catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url", "/seller/product/index");
            e.printStackTrace();
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @PostMapping("/upload")
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile file) {
        Map<String, Object> map = new HashMap<>(8);
        String filePath = "E:\\IdeaProjects\\Elm\\src\\main\\resources\\static\\images\\test\\";
        //上传后的文件名  原始文件名加上时间戳
        String fileName = System.currentTimeMillis()+"_"+file.getOriginalFilename();
        String fileAbsoluteName = filePath + fileName;
        FileOutputStream out;
        JSONObject resObj = new JSONObject();
        resObj.put("msg", "ok");
        try {
            out = new FileOutputStream(new File(fileAbsoluteName));
            IOUtils.copy(file.getInputStream(), out);
            out.close();
        } catch (Exception e) {
            resObj.put("msg", "error");
            e.printStackTrace();
        }
        resObj.put("src", "static/images/test/" + fileName);
        return resObj;
    }

    @GetMapping("del")
    public ModelAndView remove(HttpServletRequest request
            , @RequestParam String productId
            , Map<String, Object> map){
        String referer = request.getHeader("referer");
        if ("http://localhost/seller/product/list".equals(referer)) {
            productServices.remove(productId);
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/success", map);
        } else {
            map.put("url", "/seller/product/list");
            map.put("msg", "no root");
            return new ModelAndView("common/error", map);
        }
    }
}
