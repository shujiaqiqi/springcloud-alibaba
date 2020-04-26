package com.ch.service;

import com.ch.entity.CommonResult;
import com.ch.entity.PayMent;
import com.ch.service.impl.OrderNacosServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "nacos-payment-provider", fallback = OrderNacosServiceImpl.class)
public interface OrderNacosService {

    @GetMapping("paymentSQL/{id}")
    CommonResult<PayMent> paymentSQL(@PathVariable("id") Long id);
}
