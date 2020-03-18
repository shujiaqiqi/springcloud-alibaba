package com.ch.controller;

import com.ch.entity.CommonResult;
import com.ch.entity.PayMent;
import com.ch.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("list")
    public CommonResult<List<PayMent>> list() {

        return paymentFeignService.list();
    }

    @PostMapping("insert")
    public <T> CommonResult<T> insert(@RequestBody PayMent payMent) {

        log.info("payMent:{}", payMent);
        return paymentFeignService.insert(payMent);
    }

    @GetMapping("get")
    public CommonResult<PayMent> get(Long id) {

        log.info("id:{}", id);
        return paymentFeignService.get(id);
    }
}
