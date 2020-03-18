package com.ch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.ch.mapper")
@EnableEurekaClient
// 服务发现
@EnableDiscoveryClient
public class ProviderPayMent8001 {

    public static void main(String[] args) {

        SpringApplication.run(ProviderPayMent8001.class, args);
    }
}
