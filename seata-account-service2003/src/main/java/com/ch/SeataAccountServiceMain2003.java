package com.ch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Date 2020/4/26  21:07
 * @Author 十二
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ch.mapper")
public class SeataAccountServiceMain2003 {

    public static void main(String[] args) {

        SpringApplication.run(SeataAccountServiceMain2003.class);
    }
}
