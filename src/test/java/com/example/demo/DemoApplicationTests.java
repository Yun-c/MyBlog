package com.example.demo;

import com.example.demo.dao.UserList;
import com.example.demo.service.UserAuthentication;
import com.example.demo.service.UserService;
import com.mongodb.connection.QueryResult;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {

        Flux<UserList> allUsers = userService.getAllUsers();
        System.out.println("运行了1");
        List<UserList> block = allUsers.collectList().block();
        for (UserList userList : block) {
            System.out.println(userList.toString());
        }
        System.out.println("id");
        Mono<UserList> listMono = userService.findById("663de563a995da84740fc62b");

        listMono.subscribe(new Consumer<UserList>() {
            @Override
            public void accept(UserList userList) {
                System.out.println(userList.toString());
            }
        });


    }
}