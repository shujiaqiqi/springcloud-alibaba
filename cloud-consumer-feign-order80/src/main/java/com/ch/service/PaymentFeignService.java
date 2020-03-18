package com.ch.service;

import com.ch.entity.CommonResult;
import com.ch.entity.PayMent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
// 指定要调用的服务
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@RequestMapping("payment")  // ?? 为什么能这么写
public interface PaymentFeignService {

    @GetMapping("list")
    CommonResult<List<PayMent>> list();

    @PostMapping("insert")
    <T> CommonResult<T> insert(PayMent payMent);  // 这里参数可以不加注解

    @GetMapping("get")
    CommonResult<PayMent> get(@RequestParam("id") Long id);   // 单个参数需要加注解
}
