package com.ch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date 2020/4/26  16:10
 * @Author 十二
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ch.mapper")
@EnableFeignClients
public class SeataOrderServiceMain2001 {

    public static void main(String[] args) {

        SpringApplication.run(SeataOrderServiceMain2001.class);
    }
}
