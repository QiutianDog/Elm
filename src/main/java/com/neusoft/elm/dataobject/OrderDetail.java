package com.neusoft.elm.dataobject;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单详情
 * @author QiutianDog
 * @Date 2020/11/26
 */
@Entity
@Data
public class OrderDetail {
    /**
     * detailId         订单编号
     * buyerId          点餐人ID
     * productId        商品ID
     * productName      商品名字
     * productPrice     商品单价
     * productQuantity  点单数量
     * productIcon      商品图片路径
     *
     *   * 设置主键为id
     *   * 设置自增长方式为UUID
     *   * @Id
     *   * @GenericGenerator(name = "idGenerator", strategy = "uuid")
     *   * @GeneratedValue(generator = "idGenerator")
     */

    @Id
    private String orderId;

    private String buyerId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;
}
