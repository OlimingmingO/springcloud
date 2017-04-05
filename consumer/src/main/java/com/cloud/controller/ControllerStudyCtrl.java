package com.cloud.controller;
import com.cloud.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oliverlee on 2017/3/27.
 */

@Controller
public class ControllerStudyCtrl {
    @RequestMapping("/controllerstudy")
    public String ControllerStudy(){
        return "ControllerStudy";
    }
    /**
     * 返回Html文件
     */
    @RequestMapping("/ReturnHtml")
    public String ReturnHtml(){
        return "home";
    }
    /**
     * 返回字符串
     */
    @RequestMapping("/ReturnString")
    @ResponseBody
    public  String ReturnString(){
        return "home";
    }

    /**
     * 返回ModelAndView
     * 通过ModelAndView对象返回Html文件并通过Map对象返回数据
     */
    @RequestMapping("/ReturnModelAndView")
    public ModelAndView ReturnModelAndView(){
        ModelAndView modelAndView = new ModelAndView();

        Map<String, String> mapReturn = new HashMap<String, String>();
        mapReturn.put("name", "zhangsan");
        mapReturn.put("age", "18");

        modelAndView.setViewName("ModelAndView");
        modelAndView.addObject("user", mapReturn);
        return modelAndView;
    }
    /**
     * ReturnJson把对象转成Json格式返回
     * SpringBoot返回的数据自动为Json格式
     * 注意：必须要添加ResposeBody注解
     */
    @RequestMapping(value = "/ReturnJson", method = RequestMethod.POST)
    @ResponseBody
    public Person ReturnJson() {
        Person person = new Person();
        person.setPerName("lisi");
        person.setPerAge(19);
        person.setPerCreatetime(new Date());
        person.setRemarks("我是测试Return Json的");
        return person;
    }
/**************************************以下为接收参数*********************************************/
    /**
     *使用@RequestParam(value="")来改变参数名字
     *使用@RequestParam(defaultValue="")，不传参时，使用默认值
     *使用@RequestParam(required=true)，强制必须传参数
     */
    @RequestMapping(value = "/GetInput", method = RequestMethod.POST)
    @ResponseBody
    public String GetInput(@RequestParam("name") String name, @RequestParam("age") int age) {
        return "your name is ：" + name + "and age is ："+ age;
    }
    /**
     *使用占位符传参
     */
    @RequestMapping("/GetInputByPosition/{param1}/{param2}")
    @ResponseBody
    public String GetInputByPosition(@PathVariable int param1, @PathVariable int param2) {
        return "first para is ：" +  param1 + "   second para is ："+ param2;
    }
    /**

     */
    @RequestMapping(value = "/Registor", method = RequestMethod.GET)
    @ResponseBody
    public String ShowRegistionForm() {
        return "this is login , no input ";
    }
    /**
    * Form表单提交对象
     * 注意：这里的参数为什么直接使用Person，而不用@RequestBody？
     */
    @RequestMapping(value = "/Registor", method = RequestMethod.POST)
    @ResponseBody
    public Person ProcessRegistionForm(Person person) {
        return person;
    }
    /**
     * 获取文件
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String HandleFileUpload(@RequestParam("file")MultipartFile file) {
        if(!file.isEmpty()){
            try{
                File file1 = new File(file.getOriginalFilename());

                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("upload" + file1));
                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();
            }catch (FileNotFoundException e){
                e.printStackTrace();
                return"上传失败,"+e.getMessage();
            }catch (IOException e){
                e.printStackTrace();
                return"上传失败,"+e.getMessage();
            }
        }
        else {
            return "file is empty!";
        }
        return "success";
    }

}
