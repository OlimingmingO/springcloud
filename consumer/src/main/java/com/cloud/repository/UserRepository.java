package com.cloud.repository;

import com.cloud.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 启用断路器，只要添加fallback就行，指定回调的class，该class和现有接口实现相同的函数
 */

@FeignClient(value = "provider", fallback = UserRepositoryHystrix.class)
public interface UserRepository {
//    这里的映射是映射Server端的，
    @RequestMapping("/hello")
    String HelloCloud();
    /**
     * 注意：这里的参数为什么要用@RequestBody？而在Controller不需要？
     */
    @RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
    String UpdateUser(@RequestBody User user);
}
