package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// Ribbon配置类 自定义负载均衡算法
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {

        // 随机算法
        return new RandomRule();
    }
}
