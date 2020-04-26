package com.ch.service.impl;

import com.ch.entity.CommonResult;
import com.ch.entity.Order;
import com.ch.mapper.OrderMapper;
import com.ch.service.AccountService;
import com.ch.service.OrderService;
import com.ch.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date 2020/4/26  16:17
 * @Author 十二
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    public Integer create(Order order) {

        if (log.isInfoEnabled()) {
            log.info("开始新建订单");
        }

        orderMapper.create(order);

        if (log.isInfoEnabled()) {
            log.info("订单微服务下单完成，开始调用库存微服务做库存扣减");
        }

        storageService.decrease(order.getProductId(), order.getCount());

        if (log.isInfoEnabled()) {
            log.info("库存微服务调用完成，开始调用帐户微服务做余额扣减");
        }

        CommonResult<Integer> result = accountService.decrease(order.getUserId(), order.getMoney());

        if (log.isInfoEnabled()) {
            log.info("余额微服务调用完成，修改订单状态");
        }

        if (result.getData() == 1 && order.getId() != null) {
            orderMapper.update(order.getId(), 0);
            if (log.isInfoEnabled()) {
                log.info("修改订单完成");
            }
            return 1;
        } else {
            return 0;
        }
    }
}
