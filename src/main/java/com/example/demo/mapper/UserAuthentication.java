package com.example.demo.mapper;

import com.example.demo.dao.UserList;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: demo
 * @ClassName CityAuthentication
 * @description:
 * @author: Alice
 * @create: 2024-05-10 16:38
 * @Version 1.0
 **/
@Repository
public interface UserAuthentication extends ReactiveMongoRepository<UserList,String> {

}
