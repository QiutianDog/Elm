package com.neusoft.elm.services.impl;

import com.neusoft.elm.dataobject.ProductInfo;
import com.neusoft.elm.services.ProductServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author QiutianDog
 * @Date 2020/11/27
 */
@SpringBootTest
public class ProductServicesImplTest {

    @Autowired
    private ProductServices services;

    @Test
    public void save() {
        ProductInfo info = new ProductInfo();

        /**
         * private String productId;
         *
         *     private String productName;
         *
         *     private BigDecimal productPrice;
         *
         *     private Integer productStock;
         *
         *     private String productDescription;
         *
         *     private String productIcon;
         *
         *     private Integer productStatus = ProductStatusEnum.UP.getCode();
         *
         *     private Integer categoryType;
         *
         *     @CreatedDate
         *     private Date createTime;
         *
         *     @LastModifiedDate
         *     private Date updateTime;
         */
        info.setProductId("PI0001");
        info.setProductName("康师傅红烧牛肉面");
        info.setProductPrice(new BigDecimal("5.6"));
        info.setProductStock(100);
        info.setProductDescription("再来一桶！");
        info.setProductIcon("C:/images/noodles.jpg");
        info.setCategoryType(0);

        services.save(info);
    }


    @Test
    public void findOne() {
        ProductInfo one = services.findOne("PI0001");
        System.out.println(one);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list = services.findUpAll();
        for (ProductInfo info : list) {
            System.out.println(info);
        }
    }

    @Test
    public void findAll() {
        PageRequest of = PageRequest.of(0, 10);
        Page<ProductInfo> list = services.findAll(of);
        for (ProductInfo info : list) {
            System.out.println(info);
        }
    }

    @Test
    public void onSale() {
        ProductInfo info = services.onSale("PI0001");
        System.out.println(info);
    }

    @Test
    public void offSale() {
        ProductInfo info = services.offSale("PI0001");
        System.out.println(info);
    }

}
