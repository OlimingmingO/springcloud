package com.cloud.controller;

import com.cloud.bean.User;
import com.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Oliverlee on 2017/3/30.
 */
@Controller
@RequestMapping("/providerstudy")
public class ProviderStudyCtr {
    @RequestMapping("/main")
    public ModelAndView ProviderStudy(){
        ModelAndView modelAndView = new ModelAndView("Providerstudy");
       return modelAndView;
    }

    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/feign", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return userRepository.HelloCloud();
    }

    @RequestMapping(value = "/updateuserform", method = RequestMethod.POST)
    @ResponseBody
    public String UpdateUser(User user) {
        System.out.println(user.getName());
        return userRepository.UpdateUser(user);
    }

    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/ribbon", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://provider/hello", String.class).getBody();
    }


}
