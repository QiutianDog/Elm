package com.neusoft.elm.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author QiutianDog
 * @Date 2020/12/2
 */
@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue
    private Integer adminId;

    @Column(nullable = false, unique = true)
    private String adminName;

    @Column(nullable = false)
    private String adminPassword;
}
