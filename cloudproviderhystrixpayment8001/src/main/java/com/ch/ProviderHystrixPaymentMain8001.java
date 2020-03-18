package com.ch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker  // 激活服务降级
public class ProviderHystrixPaymentMain8001 {

    public static void main(String[] args) {

        SpringApplication.run(ProviderHystrixPaymentMain8001.class, args);
    }
}
