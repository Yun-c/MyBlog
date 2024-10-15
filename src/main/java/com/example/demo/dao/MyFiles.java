package com.example.demo.dao;

/**
 * @program: demo
 * @ClassName MyFiles
 * @description:
 * @author: Alice
 * @create: 2024-10-10 20:27
 * @Version 1.0
 **/

public class MyFiles {

    private String file_name;
    private String filePath;
    private String fileType;
    private String fileSize;

    public MyFiles() {
    }

    public MyFiles(String file_name, String filePath, String fileType, String fileSize) {
        this.file_name = file_name;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}
