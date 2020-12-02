package com.neusoft.elm.services.impl;

import com.neusoft.elm.dataobject.BuyerUser;
import com.neusoft.elm.repository.BuyerRepository;
import com.neusoft.elm.services.BuyerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
@Service
public class BuyerServicesImpl implements BuyerServices {

    @Autowired
    BuyerRepository repository;

    @Override
    public BuyerUser save(BuyerUser buyerUser) {
        return repository.save(buyerUser);
    }

    @Override
    public BuyerUser update(BuyerUser buyerUser) {
        return repository.save(buyerUser);
    }

    @Override
    public BuyerUser login(String buyerName, String buyerPassword) {
        return repository.findByBuyerNameAndBuyerPassword(buyerName, buyerPassword);
    }

    @Override
    public BuyerUser findById(String buyerId) {
        return repository.findById(buyerId).orElse(null);
    }


}
