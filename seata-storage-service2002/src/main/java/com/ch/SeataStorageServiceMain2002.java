package com.ch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date 2020/4/26  20:47
 * @Author 十二
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.ch.mapper")
public class SeataStorageServiceMain2002 {

    public static void main(String[] args) {

        SpringApplication.run(SeataStorageServiceMain2002.class);
    }
}
