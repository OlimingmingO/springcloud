package com.cloud.repository;

import com.cloud.bean.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Oliverlee on 2017/3/25.
 */
public interface Person2Repository extends Repository<Person, Integer> {

    /*
    * 查询方法用find | read | get开头
    * 条件语句用关键字链接，首字母大写
    * */
    public Person findByperName(String perName);

    /*
    * 自己编写JPQL语句
    * Hibernate是HQL语句
    * 两者类似
    * */
    @Query("from Person where personName=:cn")
    public Person findMyPersonName(@Param("cn") String personName);

}
