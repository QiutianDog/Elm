package com.neusoft.elm.repository;

import com.neusoft.elm.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author QiutianDog
 * @Date 2020/11/26
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
