package com.example.demo.service;

import com.example.demo.dao.UserList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

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

    public Mono<UserList> findById(String name){
        return userAuthentication.findById(name);
    }

}
