package com.neusoft.elm.services.impl;

import com.neusoft.elm.dataobject.ProductInfo;
import com.neusoft.elm.enums.ProductStatusEnum;
import com.neusoft.elm.enums.ResultEnum;
import com.neusoft.elm.exception.SellException;
import com.neusoft.elm.repository.ProductInfoRepository;
import com.neusoft.elm.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author QiutianDog
 * @Date 2020/11/26
 */
@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).orElseGet(ProductInfo::new);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo product = repository.findById(productId).orElse(null);
        if (product == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        if (product.getProductStatus().equals(ProductStatusEnum.UP.getCode())) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        product.setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(product);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo product = repository.findById(productId).orElse(null);

        if (product == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        if (product.getProductStatus().equals(ProductStatusEnum.DOWN.getCode())) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        product.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(product);
    }

    @Override
    public void increaseStock(String productId) {
        // TODO
    }

    @Override
    public void decreaseStock(String productId) {

    }
}
