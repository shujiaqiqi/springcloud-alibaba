package com.ch.controller;

import com.ch.entity.CommonResult;
import com.ch.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date 2020/4/26  20:51
 * @Author 十二
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping("decrease")
    public CommonResult<Integer> decrease(@RequestParam("productId") Long id, @RequestParam("count") Integer count) {

        storageService.decrease(id, count);
        CommonResult<Integer> commonResult = new CommonResult<>();
        commonResult.setCode(0);
        commonResult.setData(1);
        return commonResult;
    }
}
