package com.ch.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Date 2020/4/26  21:09
 * @Author 十二
 */
@Data
public class Account {

    private Long id;
    private Long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
