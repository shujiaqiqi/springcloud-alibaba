package com.ch.service.impl;

import com.ch.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {


    public String payment_ok() {

//        int a = 10/0;
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return "ok:" + Thread.currentThread().getName();
    }

    // 从8001服务提供者着手
    // 超时异常 若业务时间超过3秒，执行服务降级
    // 运行异常 也能执行服务降级
//    @HystrixCommand(fallbackMethod = "paymentOut",
//        commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//        }
//    )
    public String payment_out() {

//        int a = 10/0;
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "out:" + Thread.currentThread().getName();
    }

    // 降级方法
    public String paymentOut() {

        return "异常了："+Thread.currentThread().getName();
    }
}
