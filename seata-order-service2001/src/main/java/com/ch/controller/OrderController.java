package com.ch.controller;

import com.ch.entity.CommonResult;
import com.ch.entity.Order;
import com.ch.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date 2020/4/26  16:16
 * @Author 十二
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("create")
    public CommonResult<Integer> create(Order order) {

        Integer result = orderService.create(order);
        CommonResult<Integer> commonResult = new CommonResult<>();
        if (result == 1) {
            commonResult.setCode(0);
            commonResult.setData(result);
            return commonResult;
        } else {
            commonResult.setCode(-1);
            commonResult.setCode(result);
            return commonResult;
        }
    }
}
