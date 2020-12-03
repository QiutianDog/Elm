package com.neusoft.elm.services.impl;

import com.neusoft.elm.dataobject.Admin;
import com.neusoft.elm.repository.AdminRepository;
import com.neusoft.elm.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
@Service
public class AdminServicesImpl implements AdminServices {

    @Autowired
    AdminRepository repository;

    @Override
    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public void remove(String adminName) {
        repository.deleteByAdminName(adminName);
    }

    @Override
    public Admin update(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Admin login(String adminName, String adminPassword) {
        return repository.findByAdminNameAndAdminPassword(adminName
                , adminPassword);
    }
}
