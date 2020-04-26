package com.ch.controller;

import com.ch.entity.CommonResult;
import com.ch.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Date 2020/4/26  21:08
 * @Author 十二
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("decrease")
    public CommonResult<Integer> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {

        Integer result = accountService.decrease(userId, money);
        CommonResult<Integer> commonResult = new CommonResult<>();
        commonResult.setCode(0);
        commonResult.setData(result);
        return commonResult;
    }
}
