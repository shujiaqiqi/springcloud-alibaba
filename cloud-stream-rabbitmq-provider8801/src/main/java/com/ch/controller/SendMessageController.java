package com.ch.controller;

import com.ch.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("provider")
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("send")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
