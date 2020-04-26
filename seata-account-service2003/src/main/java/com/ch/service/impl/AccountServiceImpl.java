package com.ch.service.impl;

import com.ch.entity.Account;
import com.ch.mapper.AccountMapper;
import com.ch.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Date 2020/4/26  21:11
 * @Author 十二
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public Integer decrease(Long userId, BigDecimal money) {

        Account account = accountMapper.selectAccountByUserId(userId);
        BigDecimal newTotal = account.getTotal().subtract(money);
        BigDecimal newUsed = account.getUsed().add(money);
        accountMapper.decrease(userId, newTotal, newUsed);
        return 1;
    }
}
