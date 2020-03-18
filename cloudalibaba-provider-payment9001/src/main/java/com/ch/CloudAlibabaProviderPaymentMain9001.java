package com.ch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProviderPaymentMain9001 {

    public static void main(String[] args) {

        SpringApplication.run(CloudAlibabaProviderPaymentMain9001.class, args);
    }

    @RestController
    public static class EchoController {

        @Value("${server.port}")
        private String port;

        @GetMapping("nacos")
        public String echo() {

            return port + "  " + "hello nacos";
        }
    }
}
