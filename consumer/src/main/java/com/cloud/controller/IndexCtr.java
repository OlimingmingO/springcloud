package com.cloud.controller;

import com.cloud.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * Created by Oliverlee on 2017/3/23.
 */

//等价于@Controller 和 @RequestBody
//@RestController
//只用Controller的时候，返回到指定页面，"hello" = hello.jsp，如果需要返回Json字符数需要增加@RequestBody才行
@Controller
public class IndexCtr {
    //返回home.html
    /*方法一：通过ModelAndView来返回
    * */
    @RequestMapping("/index")
    public ModelAndView index(){
        System.out.println("Index controller is called");
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    /*方法二：通过String来返回
    * */
    @RequestMapping("/index1")
    public String index1(Map<String , Object> map){
        map.put("name", "lisi");
        return "index";
    }

}
