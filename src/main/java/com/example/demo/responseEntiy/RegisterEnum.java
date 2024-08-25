package com.example.demo.responseEntiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: demo
 * @ClassName RegisterEnum
 * @description:
 * @author: Alice
 * @create: 2024-05-30 15:50
 * @Version 1.0
 **/
@AllArgsConstructor
@Getter
public enum RegisterEnum {
    SUCCESS(true,100,"注册成功"),

    ALREADY_EXISTS(false,500,"用户已存在")
    ;

    private final Boolean success;

    private final Integer code;

    private final String message;

    @Override
    public String toString() {
        return super.toString();
    }

}
