package com.ch.service;

import com.ch.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Date 2020/4/26  16:48
 * @Author 十二
 */
@FeignClient(value = "seata-account-service")
//@Service
public interface AccountService {

    @GetMapping("account/decrease")
    CommonResult<Integer> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
