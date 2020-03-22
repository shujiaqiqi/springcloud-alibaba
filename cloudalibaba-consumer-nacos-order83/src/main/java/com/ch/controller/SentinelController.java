package com.ch.controller;

import com.ch.service.SentinelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SentinelController {

    @Resource
    private SentinelService sentinelService;

    @GetMapping("testA83")
    public String testA() {

        return sentinelService.testA();
    }

    @GetMapping("testB")
    public String testB() {

        return sentinelService.testB();
    }
}
