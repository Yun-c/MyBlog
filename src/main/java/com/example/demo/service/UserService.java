package com.example.demo.service;

import com.example.demo.dao.UserList;
import com.example.demo.mapper.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @program: demo
 * @ClassName UserService
 * @description:
 * @author: Alice
 * @create: 2024-05-10 16:55
 * @Version 1.0
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final UserAuthentication userAuthentication;

    public Mono<UserList> createUser(UserList userList){

        return userAuthentication.save(userList);
    }
    public Flux<UserList> getAllUsers(){
        return userAuthentication.findAll();
    }
    public Mono<UserList> findById(String id){
        return userAuthentication.findById(id);
    }
    public Flux<UserList> findByName(String username){
        Query name = new Query(Criteria.where("name").is(username));
        return reactiveMongoTemplate.find(name,UserList.class);
    }

    public Mono<UserList> saveUser(String name,String password){
        UserList userList = new UserList();
        userList.setUsername(name);
        userList.setPassword(password);
        return userAuthentication.save(userList);
    }



}
