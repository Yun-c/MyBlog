package com.example.demo.dao;

import lombok.*;
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
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "userList")
public class UserList {
    @Id
    private String id;
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String password;

    @Override
    public String toString() {
        return "userInfo{"+
                "id="+id+
                ",username="+username+
                ",password="+password+
                "}";
    }
}
