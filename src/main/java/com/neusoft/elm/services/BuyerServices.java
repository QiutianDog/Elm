package com.neusoft.elm.services;

import com.neusoft.elm.dataobject.BuyerUser;
import org.springframework.stereotype.Service;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
public interface BuyerServices {

    /**
     * 注册买家账号
     * @param buyerUser 买家对象
     * @return 新的买家对象
     */
    BuyerUser save(BuyerUser buyerUser);

    /**
     * 修改买家账号信息
     * @param buyerUser 买家账号
     * @return 新的买家账号
     */
    BuyerUser update(BuyerUser buyerUser);

    /**
     * 登录账号
     * @param buyerName 用户名
     * @param buyerPassword 密码
     * @return 用户名对象 可以为空
     */
    BuyerUser login(String buyerName, String buyerPassword);

    /**
     * 通过Id查找买家对象
     * @param buyerId 买家Id
     * @return 买家对象
     */
    BuyerUser findById(String buyerId);
}
