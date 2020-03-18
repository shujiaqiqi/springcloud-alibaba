package com.ch.controller;

import com.ch.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("ok")
    public String payment_ok() {

        return paymentService.payment_ok();
    }

    @GetMapping("out")
    public String payment_out() {

        return paymentService.payment_out();
    }
}