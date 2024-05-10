package com.example.demo.service;

import com.example.demo.dao.UserList;
import com.mongodb.connection.QueryResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @ClassName UserService
 * @description:
 * @author: Alice
 * @create: 2024-05-10 16:55
 * @Version 1.0
 **/
@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    @Autowired
    private CityAuthentication cityAuthentication;

    public UserList quert(String username) {
        UserList s = cityAuthentication.queryDataByUser(username);
        return s;
    }
}
