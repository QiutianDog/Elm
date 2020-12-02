package com.neusoft.elm.services.impl;

import com.neusoft.elm.dataobject.OrderMaster;
import com.neusoft.elm.enums.OrderStatusEnum;
import com.neusoft.elm.enums.PayStatusEnum;
import com.neusoft.elm.enums.ResultEnum;
import com.neusoft.elm.exception.SellException;
import com.neusoft.elm.repository.OrderMasterRepository;
import com.neusoft.elm.services.OrderMasterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
@Service
public class OrderMasterServicesImpl implements OrderMasterServices {

    @Autowired
    OrderMasterRepository repository;

    @Override
    public OrderMaster save(OrderMaster master) {
        return repository.save(master);
    }

    @Override
    public void remove(String orderId) {
        repository.deleteById(orderId);
    }

    @Override
    public OrderMaster pay(String orderId) {
        OrderMaster master = repository.findById(orderId).orElse(null);
        if (master != null) {
            Integer payStatus = master.getPayStatus();
            if (payStatus.equals(PayStatusEnum.WAIT.getCode())) {
                master.setPayStatus(PayStatusEnum.SUCCESS.getCode());
                repository.save(master);
            } else {
                throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
            }
        } else {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return master;
    }

    @Override
    public OrderMaster done(String orderId) {
        OrderMaster master = repository.findById(orderId).orElse(null);
        if (master != null) {
            Integer orderStatus = master.getOrderStatus();
            if (orderStatus.equals(OrderStatusEnum.NEW.getCode())) {
                master.setOrderStatus(OrderStatusEnum.FINISH.getCode());
                repository.save(master);
            } else {
                throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
            }
        } else {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return master;
    }

    @Override
    public OrderMaster cancel(String orderId) {
        OrderMaster master = repository.findById(orderId).orElse(null);
        if (master != null) {
            Integer orderStatus = master.getOrderStatus();
            if (!orderStatus.equals(OrderStatusEnum.CANCEL.getCode())) {
                master.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
                repository.save(master);
            } else {
                throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
            }
        } else {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return master;
    }

    @Override
    public OrderMaster findByOrderId(String orderId) {
        return repository.findById(orderId).orElse(null);
    }

}
