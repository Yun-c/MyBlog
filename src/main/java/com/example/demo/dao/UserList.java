package com.example.demo.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: demo
 * @ClassName UserList
 * @description:
 * @author: Alice
 * @create: 2024-05-08 16:41
 * @Version 1.0
 **/
//Document注解表明对应了MongoDB中的user表。
@Document(collection = "userList")
public class UserList {
    @Id
    private String username;

    private String password;

    public UserList(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userInfo{"+
                "username="+username+
                ",password="+password+
                "}";
    }
}
