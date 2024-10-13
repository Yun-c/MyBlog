package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: demo
 * @ClassName FileUpload
 * @description:
 * @author: Alice
 * @create: 2024-09-28 16:01
 * @Version 1.0
 **/
@Controller
public class FileUpload {
    @PostMapping(value = "/index/upload")
    @ResponseBody
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {

        try {
            // 写入文件
            String target_path = "/Users/sun/WorkSpace/upload/";
            Path file_path = Paths.get(target_path + file.getOriginalFilename());
            Files.copy(file.getInputStream(),file_path);
            System.out.println("请求成功！！！");
            return ResponseEntity.ok("文件上传成功!!"+file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("文件上传失败");
        }


    }
}
