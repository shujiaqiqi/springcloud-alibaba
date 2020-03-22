package com.ch.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("testA")
    @SentinelResource(value = "testA", blockHandler = "deal_testA", fallback = "error")
    public String testA() throws InterruptedException {
        int a = 10/0;
        log.info(Thread.currentThread().getName());
        return "------------testA";
    }

    @GetMapping("testB")
    public String testB() throws InterruptedException {

        int a = 1/0;
        log.info(Thread.currentThread().getName());
//        Thread.sleep(2000);
        return "------------testB";
    }

    @GetMapping("test")
    @SentinelResource(value = "test", blockHandler = "deal_test")
    public String testHotKey(Integer p1, Integer p2) {  // 非必传

        return "---------------testHotKey" + "  " + p1 + p2;
    }

    public String deal_test(Integer p1, Integer p2, BlockException exception) {

        return "deal_test";
    }

    public String deal_testA(BlockException exception) {

        return "deal_testA";
    }

    public String error() {

        return "runtime";
    }
}
