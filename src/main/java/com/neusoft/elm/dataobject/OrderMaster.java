package com.neusoft.elm.dataobject;

import com.neusoft.elm.enums.OrderStatusEnum;
import com.neusoft.elm.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author QiutianDog
 * @Date 2020/11/26
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /**
     *  订单ID
     *  买家名字
     *  买家手机号
     *  买家微信
     *  订单总金额
     *  订单状态 默认为0 新下单
     *  支付状态 默认为0 未支付
     *  创建时间
     *  更新时间
     */

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    @CreationTimestamp
    @Column(updatable = false)
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;

}
