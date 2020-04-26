package com.ch.controller;

import com.ch.entity.CommonResult;
import com.ch.entity.PayMent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, PayMent> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new PayMent(1L, "12312312321312321312312"));
        hashMap.put(2L, new PayMent(2L, "45645645645654654654645"));
        hashMap.put(3L, new PayMent(3L, "78978978987987987987987"));
    }

    @GetMapping("paymentSQL/{id}")
    public CommonResult<PayMent> paymentSQL(@PathVariable("id") Long id) {

        PayMent payMent = hashMap.get(id);
        return new CommonResult<>(200, "from mysql, serverPort: " + serverPort, payMent);
    }
}
