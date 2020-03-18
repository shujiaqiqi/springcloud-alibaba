package com.ch.controller;

import com.ch.entity.CommonResult;
import com.ch.entity.PayMent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {

    // 对于多个服务提供者，并且提供者服务名一致。只认服务名
    private final static String baseUrl = "http://CLOUD-PAYMENT-SERVICE/";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("insert")
    public <T> CommonResult<T> insert(@RequestBody PayMent payMent) {

        return restTemplate.postForObject(baseUrl+"payment/insert", payMent, CommonResult.class);
    }

    @GetMapping("list")
    public CommonResult<List<PayMent>> list() {

        return restTemplate.getForObject(baseUrl+"payment/list", CommonResult.class);
    }

    @GetMapping("getById/{id}")
    public CommonResult<PayMent> getById(@PathVariable Long id) {

        log.info("id{}", id);
        return restTemplate.getForObject(baseUrl+"payment/getById/"+id, CommonResult.class);
    }

    @GetMapping("get")
    public CommonResult<PayMent> get(Long id) {
        log.info("id{}", id);
        return restTemplate.getForObject(baseUrl+"payment/get?id="+id, CommonResult.class);
    }
}
