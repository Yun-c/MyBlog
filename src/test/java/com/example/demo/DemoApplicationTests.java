//package com.example.demo;
//
//import com.example.demo.service.UserService;
//import com.mongodb.connection.QueryResult;
//import org.apache.catalina.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.List;
//
//@SpringBootTest
//class DemoApplicationTests {
//
//	@Test
//	void contextLoads() {
//		ApplicationContext context = new AnnotationConfigApplicationContext(DemoApplicationTests.class);
//		UserService userService = context.getBean(UserService.class);
//		QueryResult quert = userService.quert("小刚");
//		List results = quert.getResults();
//		System.out.println(results);
//	}
//
//}
