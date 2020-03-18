package com.ch.service;

import com.ch.entity.PayMent;

import java.util.List;

public interface PayMentService {

    void insert(PayMent payMent);

    PayMent getById(Long id);

    List<PayMent> list();
}
