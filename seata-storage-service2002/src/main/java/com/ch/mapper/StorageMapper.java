package com.ch.mapper;

import com.ch.entity.Storage;

/**
 * @Date 2020/4/26  20:50
 * @Author 十二
 */
public interface StorageMapper {

    void decrease(Long id, Integer newTotal, Integer newUsed);

    Storage selectProductById(Long id);
}
