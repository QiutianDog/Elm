package com.neusoft.elm.services;

import com.neusoft.elm.dataobject.OrderMaster;

import java.util.List;

/**
 * @author QiutianDog
 * @Date 2020/11/29
 */
public interface OrderMasterServices {

    /**
     * 创建订单
     * @param master 订单对象
     * @return 创建好的订单对象
     */
    OrderMaster save(OrderMaster master);

    /**
     * 删除订单
     * @param orderId 订单Id
     */
    void remove(String orderId);

    /**
     * 支付订单
     * @param orderId 订单Id
     * @return 更新后的订单
     */
    OrderMaster pay(String orderId);

    /**
     * 完成订单
     * @param orderId 订单Id
     * @return 更新后的订单
     */
    OrderMaster done(String orderId);

    /**
     * 取消订单
     * @param orderId 订单Id
     * @return 更新后的订单
     */
    OrderMaster cancel(String orderId);

    /**
     * 通过订单编号查找订单信息
     * @param orderId 订单编号
     * @return 订单对象
     */
    OrderMaster findByOrderId(String orderId);

    /**
     * 查询所有订单
     * @return 所有订单对象
     */
    List<OrderMaster> findAll();
}
