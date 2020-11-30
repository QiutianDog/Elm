package com.neusoft.elm.controller;

import com.neusoft.elm.dataobject.ProductCategory;
import com.neusoft.elm.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author QiutianDog
 * @Date 2020/11/30
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    CategoryServices services;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> list = services.findAll();
        // 将 list 添加到 map
        map.put("categoryList", list);
        return new ModelAndView("category/list", map);
    }


}
