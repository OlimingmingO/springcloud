package com.cloud.repository;

import com.cloud.bean.User;
import org.springframework.stereotype.Component;

/**
 * Created by Oliverlee on 2017/3/29.
 */
@Component
public class UserRepositoryHystrix implements UserRepository {
    @Override
    public String HelloCloud(){
        return "Hello Cloud Hystrix is called";
    };

    @Override
    public String UpdateUser(User user){
        return "UpdateUser Hystrix is called";
    };

}
