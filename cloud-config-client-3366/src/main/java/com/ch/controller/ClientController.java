package com.ch.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
@RefreshScope
public class ClientController {

    @Value("${config.info}")
    private String info;

    @GetMapping("info")
    public String getInfo() {

        return info;
    }
}
