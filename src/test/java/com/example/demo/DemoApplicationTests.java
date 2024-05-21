package com.example.demo;

import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {

//        Flux<UserList> allUsers = userService.getAllUsers();
//        System.out.println("运行了1");
//        List<UserList> block = allUsers.collectList().block();
//        for (UserList userList : block) {
//            System.out.println(userList.toString());
//        }
//        System.out.println("id");
//        Mono<UserList> listMono = userService.findById("663de563a995da84740fc62b");
//
//        listMono.subscribe(new Consumer<UserList>() {
//            @Override
//            public void accept(UserList userList) {
//                System.out.println(userList.toString());
//            }
//        });
//
//        Flux<UserList> userListFlux = userService.findByName("小明");
//        System.out.println("查询3----");
//        List<UserList> block1 = userListFlux.collectList().block();
//        for (UserList userList : block1) {
//            System.out.println(userList.toString());
//        }
//
//        System.out.println("保存3----");
//        Mono<UserList> listMono1 = userService.saveUser("小红", "3434");
//        UserList block2 = listMono1.block();
//        System.out.println(block2);


    }
}