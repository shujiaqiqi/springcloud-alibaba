package com.ch.mapper;

import com.ch.entity.Account;

import java.math.BigDecimal;

/**
 * @Date 2020/4/26  21:09
 * @Author 十二
 */
public interface AccountMapper {

    Account selectAccountByUserId(Long userId);

    void decrease(Long userId, BigDecimal newTotal, BigDecimal newUsed);
}
