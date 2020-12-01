package com.neusoft.elm.services.impl;

import com.neusoft.elm.dataobject.ProductCategory;
import com.neusoft.elm.services.CategoryServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author QiutianDog
 * @Date 2020/11/30
 */
@SpringBootTest
public class CategoryServicesImplTest {

    @Autowired
    CategoryServices services;

    @Test
    public void add() {
        ProductCategory category = new ProductCategory();

        category.setCategoryName("女生最爱");
        category.setCategoryType(2);

        services.save(category);
    }
}
