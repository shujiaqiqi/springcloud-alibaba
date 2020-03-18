package com.ch.service;

import com.ch.service.impl.PaymentFeignHystrixFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// 指定要调用的微服务 以及方法  fallback指定降级类 分别为每个方法指定降级处理，并且与业务代码解耦
@FeignClient(value = "cloud-payment-hystrix-service", fallback = PaymentFeignHystrixFallBack.class)
public interface PaymentFeignHystrixService {

    // 基于restful 请求路径需要一致，可以携带参数，方法名可以不一致
    @GetMapping("payment/ok")
    String payment_ok();

    @GetMapping("payment/out")
    String payment_out();
}
