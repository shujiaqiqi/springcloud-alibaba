package com.ch.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloudalibaba-sentinel-service")
public interface SentinelService {

    @GetMapping("testA")
    String testA();

    @GetMapping("testB")
    String testB();
}
