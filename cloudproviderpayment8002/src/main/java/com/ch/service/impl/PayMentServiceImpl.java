package com.ch.service.impl;

import com.ch.entity.PayMent;
import com.ch.mapper.PayMentMapper;
import com.ch.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PayMentServiceImpl implements PayMentService {

    @Resource
    private PayMentMapper payMentMapper;

    @Override
    public void insert(PayMent payMent) {
        payMentMapper.insert(payMent);
    }

    @Override
    public PayMent getById(Long id) {
        return payMentMapper.getById(id);
    }

    @Override
    public List<PayMent> list() {
        return payMentMapper.list();
    }
}
