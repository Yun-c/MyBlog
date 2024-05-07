package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: demo
 * @ClassName UserController
 * @description:
 * @author: Alice
 * @create: 2024-05-07 15:19
 * @Version 1.0
 **/

//注入的时候一定要是Controller 不要是RestController 因为它是rest接口（json格式） 是解析不到html
@Controller
@RequestMapping("/index")
public class UserController {

@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "loginPage";
    }



}
