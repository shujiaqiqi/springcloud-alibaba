package com.ch.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.ch.service.PaymentFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentController {

    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;

    // =========================== 服务降级

    @GetMapping("ok")
//    @HystrixCommand()
    public String ok() {

//        int a = 10/0;
        return paymentFeignHystrixService.payment_ok();
    }

    // 着手客户端
    // 超时异常  超时之后执行降级方法  或者运行异常降级
    // 但是这样写导致代码膨胀 需要为每个方法声明一个降级方法，而且降级方法与业务方法耦合
    @GetMapping("out")
//    @HystrixCommand(fallbackMethod = "paymentTimeOut",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//            }
//    )
//    @HystrixCommand() // 优化   配合DefaultProperties注解进行全局降级配置  缺点代码耦合
    // 解决方法，为service接口写一个实现类，在方法实现中处理降级
    public String out() {

//        int a = 10/0;
        return paymentFeignHystrixService.payment_out();
    }

    // 该类全局降级方法
    public String payment_Global_FallbackMethod() {

        return "消费80，执行服务降级方法";
    }



    // ============================= 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  // 失败率到达多少后跳闸
    })
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {

        if (id < 0) {
            throw new RuntimeException("参数有误");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "流水号" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数" + id;
    }
}