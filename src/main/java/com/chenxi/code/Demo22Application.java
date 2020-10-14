package com.chenxi.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.chenxi.**.dao"})
public class Demo22Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo22Application.class, args);
    }

}
