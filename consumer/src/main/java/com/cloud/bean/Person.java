package com.cloud.bean;

import com.alibaba.fastjson.annotation.JSONField;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Oliverlee on 2017/3/22.
 */

/**
 * 使用Entity注解会自动从代码生成数据库表
 * Entity这个标记依赖于pom.xml中的spring-boot-starter-data-jpa
 */
@Entity
public class Person {
    //使用@Id指定主键
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //根据大小写生成列名per_Name
    private String perName;
    private int perAge;
    @JSONField(format = "YYYY-MM-dd HH:mm")
    private Date perCreatetime;
    /*
    * 设置是否需要序列化，设为false则不会被jason序列化传出去
    * */
    @JSONField(serialize = true)
//    @JSONField(serialize = false)
    private String remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public int getPerAge() {
        return perAge;
    }

    public void setPerAge(int perAge) {
        this.perAge = perAge;
    }

    public Date getPerCreatetime() {
        return perCreatetime;
    }

    public void setPerCreatetime(Date perCreatetime) {
        this.perCreatetime = perCreatetime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
