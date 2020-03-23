package com.ch.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ch.entity.CommonResult;
import com.ch.entity.PayMent;
import com.ch.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {

        return new CommonResult(200, "按资源名称测试ok", new PayMent());
    }

    @GetMapping("/byHandler")
    @SentinelResource(value = "byHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public CommonResult byHandler() {

        return new CommonResult(200, "按资源名称测试ok", new PayMent());
    }


}