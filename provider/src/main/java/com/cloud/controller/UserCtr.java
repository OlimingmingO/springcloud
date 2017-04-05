package com.cloud.controller;
import com.cloud.bean.User;
import com.cloud.reponsitory.UserReponsitory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Oliverlee on 2017/3/29.
 */

@RestController
public class UserCtr {

    @Autowired
    private DiscoveryClient client;

    @Resource
    UserReponsitory userReponsitory;

    @RequestMapping("/hello")
    public String HelloCloud(){
        return "helloCloud";
    }

    @RequestMapping("/UpdateUser")
    @ResponseBody
    public String UpdateUser(@RequestBody User user){
        System.out.println(user.getName());
        userReponsitory.save(user);
        return "Provider UpdateUser Is Called";
    }
}
