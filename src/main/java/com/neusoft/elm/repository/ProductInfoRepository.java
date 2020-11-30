package com.neusoft.elm.repository;

import com.neusoft.elm.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author QiutianDog
 * @Date 2020/11/26
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**
     * 通过商品状态查询商品
     * @param productStatus 商品状态
     * @return 商品信息列表
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
