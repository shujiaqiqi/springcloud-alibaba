package com.ch.controller;

import com.ch.entity.CommonResult;
import com.ch.entity.PayMent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {

    // 对于多个服务提供者，并且提供者服务名一致。只认服务名
    private final static String baseUrl = "http://consul-provider-payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("port")
    public String paymentInfo() {

        return restTemplate.getForObject(baseUrl + "payment/port", String.class);
    }
}
