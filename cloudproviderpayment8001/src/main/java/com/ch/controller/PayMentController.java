package com.ch.controller;

import com.ch.entity.CommonResult;
import com.ch.entity.PayMent;
import com.ch.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("payment")
@Slf4j
public class PayMentController {

    @Resource
    private PayMentService payMentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("insert")
    public <T> CommonResult<T> insert(@RequestBody PayMent payMent) {
        CommonResult<T> commonResult = new CommonResult<T>();
        payMentService.insert(payMent);
        commonResult.setCode(Integer.valueOf(port));
        return commonResult;
    }

    @GetMapping("getById/{id}")
    public CommonResult<PayMent> getById(@PathVariable Long id) {
        log.info("id{}", id);
        CommonResult<PayMent> commonResult = new CommonResult<>();
        PayMent byId = payMentService.getById(id);
        log.info("payment{}", byId);
        commonResult.setCode(Integer.valueOf(port));
        commonResult.setData(byId);
        return commonResult;
    }

    @GetMapping("get")
    public CommonResult<PayMent> get(Long id) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("id{}", id);
        CommonResult<PayMent> commonResult = new CommonResult<>();
        PayMent byId = payMentService.getById(id);
        log.info("payment{}", byId);
        commonResult.setCode(Integer.valueOf(port));
        commonResult.setData(byId);
        return commonResult;
    }

    @GetMapping("list")
    public CommonResult<List<PayMent>> list() {
        log.info("haha");
        CommonResult<List<PayMent>> commonResult = new CommonResult<>();
        List<PayMent> list = payMentService.list();
        commonResult.setCode(Integer.valueOf(port));
        commonResult.setData(list);
        return commonResult;
    }

    @GetMapping("discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("com.ch.service:{}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("serviceId:{}, host:{}, port:{}, uri:{}", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return this.discoveryClient;
    }
}