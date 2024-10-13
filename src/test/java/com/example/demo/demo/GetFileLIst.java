package com.example.demo.demo;

import com.example.demo.dao.MyFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * @program: demo
 * @ClassName GetFileLIst
 * @description:
 * @author: Alice
 * @create: 2024-10-13 09:44
 * @Version 1.0
 **/
public class GetFileLIst {

    public static void main(String[] args) throws IOException {
        String path = "/Users/sun/WorkSpace/upload/";
        File file = new File(path);

        ArrayList<MyFiles> list = new ArrayList<>();


        Files.walkFileTree(file.toPath(), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                System.out.println(file.toAbsolutePath());
                String file_name = file.getFileName().toString();
                long length = file.toFile().length()/1024;
                String file_path = file.toAbsolutePath().toString();
                MyFiles myFiles = new MyFiles();
                myFiles.setFileName(file_name);
                myFiles.setFileSize(length+"KB");
                myFiles.setFilePath(file_path);
                list.add(myFiles);
                return super.visitFile(file, attrs);
            }
        });

    }
}
