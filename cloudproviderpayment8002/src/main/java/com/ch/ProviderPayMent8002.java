package com.ch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.ch.mapper")
@EnableEurekaClient
public class ProviderPayMent8002 {

    public static void main(String[] args) {

        SpringApplication.run(ProviderPayMent8002.class, args);
    }
}
