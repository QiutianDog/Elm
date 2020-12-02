package com.neusoft.elm.controller;

import com.neusoft.elm.dataobject.ProductCategory;
import com.neusoft.elm.exception.SellException;
import com.neusoft.elm.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        return new ModelAndView("seller/category/list", map);
    }

    @RequestMapping("index")
    public ModelAndView save(@RequestParam(required = false) Integer categoryId
            , Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory one = services.findOne(categoryId);
            map.put("category", one);
            return new ModelAndView("seller/category/index", map);
        }
        return new ModelAndView("seller/category/index", map);
    }

    @PostMapping("save")
    public ModelAndView save(HttpServletRequest request
            , Map<String, Object> map){
        ProductCategory category = new ProductCategory();

        try {
            category.setCategoryName(request.getParameter("categoryName"));
            category.setCategoryType(Integer.valueOf(request.getParameter("categoryType")));
            services.save(category);
        }catch (SellException e) {
            map.put("url", "/seller/category/index");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/category/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("del")
    public ModelAndView remove(HttpServletRequest request
            , @RequestParam Integer categoryId
            , Map<String, Object> map) {
        String referer = request.getHeader("referer");
        if ("http://localhost/seller/category/list".equals(referer)) {
            services.remove(categoryId);
            map.put("url", "/seller/category/list");
            return new ModelAndView("common/success", map);
        } else {
            map.put("url", "/seller/category/list");
            map.put("msg", "no root");
            return new ModelAndView("common/error", map);
        }
    }
}
