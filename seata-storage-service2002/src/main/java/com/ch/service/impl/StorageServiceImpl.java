package com.ch.service.impl;

import com.ch.entity.Storage;
import com.ch.mapper.StorageMapper;
import com.ch.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date 2020/4/26  20:49
 * @Author 十二
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long id, Integer count) {

        Storage storage = storageMapper.selectProductById(id);
        Integer newTotal = storage.getTotal() - count;
        Integer newUsed = storage.getUsed() + count;
        storageMapper.decrease(id, newTotal, newUsed);
    }
}
