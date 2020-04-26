package com.ch.entity;

import lombok.Data;

/**
 * @Date 2020/4/26  20:57
 * @Author 十二
 */
@Data
public class Storage {

    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
