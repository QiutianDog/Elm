package com.neusoft.elm.services;

import com.neusoft.elm.dataobject.OrderDetail;

import java.util.List;

/**
 * @author QiutianDog
 * @Date 2020/11/29
 */
public interface OrderDetailServices {

    /**
     * 创建用户订单对象
     * @param detail 订单信息
     * @return 订单
     */
    OrderDetail save(OrderDetail detail);

    /**
     * 删除订单
     * @param orderId 订单Id
     */
    void remove(String orderId);

    /**
     * 查找所有的订单
     * @return 订单列表
     */
    List<OrderDetail> findAll();

    /**
     * 通过ID查找订单
     * @param orderId ID
     * @return 订单
     */
    OrderDetail findById(String orderId);
}
