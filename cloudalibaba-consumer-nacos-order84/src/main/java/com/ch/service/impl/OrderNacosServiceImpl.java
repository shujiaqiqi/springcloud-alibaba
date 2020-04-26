package com.ch.service.impl;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ch.entity.CommonResult;
import com.ch.entity.PayMent;
import com.ch.service.OrderNacosService;
import org.springframework.stereotype.Component;

@Component
public class OrderNacosServiceImpl implements OrderNacosService {

    @Override
    public CommonResult<PayMent> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务异常返回", new PayMent(id, null));
    }
}