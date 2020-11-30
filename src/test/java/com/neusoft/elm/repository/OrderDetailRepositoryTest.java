package com.neusoft.elm.repository;

import com.neusoft.elm.dataobject.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author QiutianDog
 * @Date 2020/11/26
 */
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setDetailId(1);

        /**
         *     private Integer detailId;
         *
         *     private String orderId;
         *
         *     private String productId;
         *
         *     private String productName;
         *
         *     private BigDecimal productPrice;
         *
         *     private Integer productQuantity;
         *
         *     private String productIcon;
         *
         */
    }

}
