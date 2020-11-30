package com.neusoft.elm.repository;

import com.neusoft.elm.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author QiutianDog
 * @Date 2020/11/26
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * 通过类目类型来查找类目
     * @param categoryTypeList 类目类型列表
     * @return 几个类目类型的类目列表
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
