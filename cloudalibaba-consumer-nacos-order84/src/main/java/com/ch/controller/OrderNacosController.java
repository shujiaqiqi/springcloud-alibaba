package com.ch.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ch.entity.CommonResult;
import com.ch.entity.PayMent;
import com.ch.service.OrderNacosService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderNacosController {

    @Value("${server_url.name}")
    private String SERVER_NAME;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private OrderNacosService orderNacosService;

    @GetMapping("paymentSQL/{id}")
    @SentinelResource(value = "fallback")
    public CommonResult<PayMent> paymentSQL(@PathVariable Long id) {

        return orderNacosService.paymentSQL(id);
    }

//    @GetMapping("fallback/{id}")
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallBack")
//    public CommonResult<PayMent> test(@PathVariable Long id) {
//        if (id == 4) {
//            throw new IllegalArgumentException("非法参数");
//        }
//        CommonResult forObject = restTemplate.getForObject(SERVER_NAME + "/paymentSQL/" + id, CommonResult.class);
//        if (forObject.getData() == null) {
//            throw new NullPointerException("空的");
//        }
//        return forObject;
//    }

    public CommonResult<PayMent> handlerFallBack(@PathVariable Long id, Throwable e) {
        PayMent payMent = new PayMent(id, "null");
        return new CommonResult<>(444, "自定义异常" + e.getMessage(), payMent);
    }

    public CommonResult<PayMent> blockHandler(@PathVariable Long id, BlockException e) {
        PayMent payMent = new PayMent(id, "null");
        return new CommonResult<>(444, "Sentinel配置异常" + e.getMessage(), payMent);
    }
}
