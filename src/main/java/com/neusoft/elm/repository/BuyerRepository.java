package com.neusoft.elm.repository;

import com.neusoft.elm.dataobject.BuyerUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
public interface BuyerRepository extends JpaRepository<BuyerUser, String> {

    /**
     * 登录
     * @param buyerName 用户名
     * @param buyerPassword 密码
     * @return 用户对象 可以为空
     */
    BuyerUser findByBuyerNameAndBuyerPassword(String buyerName, String buyerPassword);

}
