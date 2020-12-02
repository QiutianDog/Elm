package com.neusoft.elm.from;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
@Data
public class OrderFrom {
    private String orderId;
    private String productName;
    private String productIcon;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private Integer payStatus;
    private Integer orderStatus;
    private Date createTime;
    private Date updateTime;
}
