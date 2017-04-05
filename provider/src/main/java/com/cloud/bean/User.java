package com.cloud.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Oliverlee on 2017/3/30.
 */
@Entity
public class User {
    //使用@Id指定主键
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public String name;
    public String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
