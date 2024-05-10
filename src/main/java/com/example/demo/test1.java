package com.example.demo;

import com.example.demo.dao.UserList;
import com.example.demo.service.UserService;
import com.mongodb.connection.QueryResult;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @program: demo
 * @ClassName test1
 * @description:
 * @author: Alice
 * @create: 2024-05-10 17:19
 * @Version 1.0
 **/
public class test1 {

    public static void main(String[] args) {

        UserService userService = new UserService();
        UserList qq = userService.quert("小刚");
        System.out.println(qq);

    }
}
