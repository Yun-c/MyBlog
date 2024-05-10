package com.example.demo.service;

import com.example.demo.dao.UserList;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.connection.QueryResult;
import org.springframework.data.mongodb.repository.Query;
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
public interface CityAuthentication extends ReactiveMongoRepository<UserList,String> {
    @Query("{ 'username':{'$regex':?1 } }")
    UserList queryDataByUser(String username);
}
