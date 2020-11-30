package com.neusoft.elm.services;

import com.neusoft.elm.dataobject.ProductCategory;

import java.util.List;

/**
 * @author QiutianDog
 * @Date 2020/11/27
 */
public interface CategoryServices {

    /**
     * 查询一条
     * @param categoryId 类目ID
     * @return 产品类目信息
     */
    ProductCategory findOne(Integer categoryId);


    /**
     * 查询所有
     * @return 所有产品类目所封装成的List集合
     */
    List<ProductCategory> findAll();


    /**
     * 根据类目类型查询
     * @param categoryTypeList 产品类名类型封装成的List集合
     * @return 同一产品类目类型所封装成的List集合
     */
    List<ProductCategory> findByCategoryType(List<Integer> categoryTypeList);


    /**
     * 存储一个类目
     * @param productCategory 产品类目
     * @return 存储之后的产品类目
     */
    ProductCategory save(ProductCategory productCategory);

}
