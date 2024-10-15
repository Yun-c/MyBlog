package com.example.demo.controller;

import com.example.demo.dao.MyFiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * @program: demo
 * @ClassName FileList
 * @description:
 * @author: Alice
 * @create: 2024-10-10 20:30
 * @Version 1.0
 **/
@RestController
public class FileList {

    private static final String file_path="/Users/sun/WorkSpace/upload/";


    @GetMapping("/index/getFilelist")
    public ResponseEntity<ArrayList<MyFiles>> getFilelist() throws IOException {

        ArrayList<MyFiles> list = new ArrayList<>();

        File file = new File(file_path);

       Files.walkFileTree(file.toPath(), new SimpleFileVisitor<>() {
           @Override
           public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                System.out.println(file.toAbsolutePath());
               String file_name = file.getFileName().toString();
               System.out.println(file_name);
               long length = file.toFile().length()/1024;
               String file_path = file.toAbsolutePath().toString();
               MyFiles myFiles = new MyFiles();
               myFiles.setFile_name(file_name);
               myFiles.setFileSize(length+"KB");
               myFiles.setFilePath(file_path);
               list.add(myFiles);
               return super.visitFile(file, attrs);
           }
        });

//        System.out.println(list);
        return ResponseEntity.ok(list);

    }
}
