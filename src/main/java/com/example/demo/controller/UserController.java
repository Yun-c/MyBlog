package com.example.demo.controller;

import com.example.demo.dao.UserList;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    UserService userService;

    // 登录页面路由
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "loginPage";
    }

    // 登录校验路由
    @RequestMapping(value = "/login1", method = RequestMethod.GET)
    public String aa() {
        UserList us = userService.quert("小刚");

        System.out.println(us);
        return us.toString();
    }


}
