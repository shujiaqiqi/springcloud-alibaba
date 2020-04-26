package com.ch.mapper;

import com.ch.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @Date 2020/4/26  16:17
 * @Author 十二
 */
public interface OrderMapper {

    void create(@Param("order") Order order);

    void update(Long id, int status);
}
