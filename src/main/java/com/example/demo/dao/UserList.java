package com.example.demo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userList")
public class UserList {
    @Id
    private String id;
    private String username;
    private String password;

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
                "id="+id+
                ",username="+username+
                ",password="+password+
                "}";
    }
}
