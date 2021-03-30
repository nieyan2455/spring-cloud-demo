package com.ny.springcloud.feign;

import com.ny.springcloud.entities.CommonResult;

/**
 * @author nieyan
 * @create 2021-03-17 10:05
 **/
public class AccountFeignServiceFallback implements AccountFeignService {
    @Override
    public CommonResult decrease(Long userId, Long money) {
        return new CommonResult(500,"error");
    }

    @Override
    public CommonResult checkAccount(Long userId, Long money) {
        return new CommonResult(500,"error");
    }
}
