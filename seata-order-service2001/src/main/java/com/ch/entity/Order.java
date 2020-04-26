package com.ch.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Date 2020/4/26  16:15
 * @Author 十二
 */
@Data
public class Order {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;
}
