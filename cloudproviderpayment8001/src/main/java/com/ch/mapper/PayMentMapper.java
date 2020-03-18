package com.ch.mapper;

import com.ch.entity.PayMent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayMentMapper {

    void insert(PayMent payMent);

    PayMent getById(Long id);

    List<PayMent> list();
}
