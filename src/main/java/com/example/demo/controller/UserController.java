package com.example.demo.controller;

import com.example.demo.dao.UserList;
import com.example.demo.responseEntiy.LoginResultEnum;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

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
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserList userList) {
        //登录状态码
        LoginResultEnum status = null;

        //用户信息
        String username = userList.getUsername();
        String password = userList.getPassword();
        System.out.println("用户名:" + username + ",密码:" + password);
        Flux<UserList> byName = userService.findByName(username);
        List<UserList> block = byName.collectList().block();

        //用户信息校验
        if (block == null || block.isEmpty()) {
            status = LoginResultEnum.NOT_FOUND;
            System.out.println("block为空");
        }else if (block.size() > 1) {
            status = LoginResultEnum.ABNORMAL;
            System.out.println("block异常");
        } else {
            System.out.println("用户验证开始");
            for (UserList list : block) {
                String dbPassword = list.getPassword();
                String dbUsername = list.getUsername();
                //密码 用户名校验
                if (!dbUsername.equals(username)) {
                    System.out.println("用户名:"+list.getUsername());
                    status = LoginResultEnum.NOT_FOUND;
                } else if (!dbPassword.equals(password)) {
                    status = LoginResultEnum.ERROR_PASSWORD;
                    System.out.println("用户名:"+list.getUsername());
                }else{
                    status = LoginResultEnum.SUCCESS;
                    System.out.println("dbusername"+dbUsername+"dbPassword:"+dbPassword);
                }
            }
        }

        return new ResponseEntity<>(status.getCode(), HttpStatus.OK);
    }

    // 注册路由



}
