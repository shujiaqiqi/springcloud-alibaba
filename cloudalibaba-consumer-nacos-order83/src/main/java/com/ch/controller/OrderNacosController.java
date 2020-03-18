package com.ch.controller;

import com.ch.service.OrderNacosService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderNacosController {

    @Resource
    private OrderNacosService orderNacosService;

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_NAME;

    // nacos利用redisTemplate和ribbon进行微服务调用
//    @GetMapping("nacos")
//    public String order() {
//
//        return restTemplate.getForObject(SERVICE_NAME + "/nacos", String.class);
//    }

    // nacos利用openFeign和ribbon进行微服务调用
    @GetMapping("nacos")
    public String order() {

        return orderNacosService.echo();
    }
}
