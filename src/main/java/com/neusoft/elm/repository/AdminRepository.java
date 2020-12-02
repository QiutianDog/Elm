package com.neusoft.elm.repository;

import com.neusoft.elm.dataobject.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    /**
     * 通过管理员名删除管理员对象
     * @param adminName 管理员名
     */
    void deleteByAdminName(String adminName);

    /**
     * 验证登录
     * @param adminName 管理名
     * @param adminPassword 管理员密码
     * @return 管理员账号 可以为null
     */
    Admin findByAdminNameAndAdminPassword(String adminName, String adminPassword);

}
