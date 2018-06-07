package com.wutong;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = { "com.wutong.user.mapper" })
public class UserServiceApplication {

    public static void main(String args[]) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


}
