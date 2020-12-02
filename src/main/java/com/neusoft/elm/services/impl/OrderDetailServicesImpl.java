package com.neusoft.elm.services.impl;

import com.neusoft.elm.dataobject.OrderDetail;
import com.neusoft.elm.repository.OrderDetailRepository;
import com.neusoft.elm.services.OrderDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
@Service
public class OrderDetailServicesImpl implements OrderDetailServices {

    @Autowired
    OrderDetailRepository repository;

    @Override
    public OrderDetail save(OrderDetail detail) {
        return repository.save(detail);
    }

    @Override
    public void remove(String orderId) {
        repository.deleteById(orderId);
    }

    @Override
    public List<OrderDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public OrderDetail findById(String orderId) {
        return repository.findById(orderId).orElse(null);
    }
}
