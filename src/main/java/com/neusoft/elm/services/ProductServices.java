package com.neusoft.elm.services;

import com.neusoft.elm.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author QiutianDog
 * @Date 2020/11/26
 */
public interface ProductServices {

    /**
     * 查询一个商品
     * @param productId 商品ID
     * @return 商品信息对象
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有上架的商品
     * @return 所有上架的商品信息对象列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有商品 分页查询
     * @param pageRequest 页面参数
     * @return 页面
     */
    Page<ProductInfo> findAll(PageRequest pageRequest);

    /**
     * 添加一个商品
     * @param productInfo 商品信息对象
     * @return 上架的商品信息对象
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 上架商品
     * @param productId 商品Id
     * @return 商品对象
     */
    ProductInfo onSale(String productId);

    /**
     * 下架商品
     * @param productId 商品Id
     * @return 商品对象
     */
    ProductInfo offSale(String productId);

    /**
     * 增加库存
     * @param productId 商品Id
     */
    void increaseStock(String productId);

    /**
     * 减少库存
     * @param productId 商品Id
     */
    void decreaseStock(String productId);

    /**
     * 通过Id删除对象
     * @param productId ID
     */
    void remove(String productId);
}
