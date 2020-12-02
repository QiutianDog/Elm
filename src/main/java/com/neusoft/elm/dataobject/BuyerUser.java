package com.neusoft.elm.dataobject;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
@Entity
@Data
public class BuyerUser {
    /**
     * 买家编号
     * 用户名
     * 密码
     * 手机号
     * 微信号
     * 余额
     * 订单编号
     */

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String buyerId;

    private String buyerName;

    private String buyerPassword;

    @Column(length = 11)
    private String buyerPhoneNumber;

    private String wechatId;

    private BigDecimal buyerMoney;

    private String buyerAddress;
}
