package com.ch.service;

import java.math.BigDecimal;

/**
 * @Date 2020/4/26  21:10
 * @Author 十二
 */
public interface AccountService {

    Integer decrease(Long userId, BigDecimal money);
}
