package com.ch.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ch.entity.CommonResult;

// 自定义限流处理逻辑
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {

        return new CommonResult(4441, exception.getClass().getCanonicalName());
    }

    public static CommonResult handlerException2(BlockException exception) {

        return new CommonResult(4442, exception.getClass().getCanonicalName());
    }
}
