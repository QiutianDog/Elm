package com.neusoft.elm.services.impl;

import com.neusoft.elm.dataobject.ProductCategory;
import com.neusoft.elm.repository.ProductCategoryRepository;
import com.neusoft.elm.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QiutianDog
 * @Date 2020/11/27
 */
@Service
public class CategoryServicesImpl implements CategoryServices {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).orElseGet(ProductCategory::new);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryType(List<Integer> categoryTypeList) {
        return findByCategoryType(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
