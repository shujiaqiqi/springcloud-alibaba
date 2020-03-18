package com.ch.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-payment-provider")
public interface OrderNacosService {

    @GetMapping("nacos")
    String echo();
}