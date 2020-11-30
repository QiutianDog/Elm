package com.neusoft.elm.controller;

import com.neusoft.elm.dataobject.ProductInfo;
import com.neusoft.elm.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiutianDog
 * @Date 2020/11/27
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices services;

    @GetMapping("/list")
    public Page<ProductInfo> findAll(@RequestParam(defaultValue = "1") Integer pageNumber
            , @RequestParam(defaultValue = "5") Integer pageSize) {
        PageRequest of = PageRequest.of(pageNumber - 1, pageSize);
        return services.findAll(of);
    }
}
