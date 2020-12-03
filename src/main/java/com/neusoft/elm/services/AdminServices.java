package com.neusoft.elm.services;

import com.neusoft.elm.dataobject.Admin;
import org.springframework.stereotype.Service;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
public interface AdminServices {

    /**
     * 增加管理员对象
     * @param admin 管理员对象
     * @return 新生成的管理员对象
     */
    Admin save(Admin admin);

    /**
     * 通过管理员账号删除管理员对象
     * @param adminName 管理员名
     */
    void remove(String adminName);

    /**
     * 修改管理员
     * @param admin 新管理员
     * @return 修改之后的管理员
     */
    Admin update(Admin admin);

    /**
     * 登录
     * @param adminName 用户名
     * @param adminPassword 密码
     * @return 管理员账号
     */
    Admin login(String adminName, String adminPassword);
}
