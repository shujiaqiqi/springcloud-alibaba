package com.ch.service.impl;

import com.ch.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Component;

// 统一降级处理类   超时、运行异常、宕机等降级处理
@Component
public class PaymentFeignHystrixFallBack implements PaymentFeignHystrixService {
    @Override
    public String payment_ok() {

        return "payment_ok降级方法";
    }

    @Override
    public String payment_out() {

        return "payment_out降级方法";
    }
}
