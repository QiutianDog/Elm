package com.neusoft.elm.controller;

import com.neusoft.elm.dataobject.ProductInfo;
import com.neusoft.elm.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author QiutianDog
 * @Date 2020/11/27
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductServices services;

    @GetMapping("/list")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer pageNumber
            , @RequestParam(defaultValue = "5") Integer pageSize
            , Map<String, Object> map) {
        PageRequest of = PageRequest.of(pageNumber - 1, pageSize);
        Page<ProductInfo> pages = services.findAll(of);
        map.put("productList", pages);
        map.put("pageNumber", pageNumber);
        map.put("pageSize", pageSize);
        return new ModelAndView("product/list", map);
    }

    @PostMapping("index")
    public ModelAndView save() {
        return null;
    }

}
