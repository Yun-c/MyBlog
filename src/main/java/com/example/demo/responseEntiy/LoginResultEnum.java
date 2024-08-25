package com.example.demo.responseEntiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @program: demo
 * @ClassName LoginResultEnum
 * @description:
 * @author: Alice
 * @create: 2024-05-27 14:32
 * @Version 1.0
 **/
@AllArgsConstructor
@Getter
public enum LoginResultEnum {

        SUCCESS(true,100,"登录成功"),
        NOT_FOUND(false,200,"用户不存在"),
        ERROR_PASSWORD(false,300,"密码错误"),
        ABNORMAL(false,400,"用户异常，联系管理员处理"),
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
