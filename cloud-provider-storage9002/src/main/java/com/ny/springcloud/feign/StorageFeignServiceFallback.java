package com.ny.springcloud.feign;

import com.ny.springcloud.entities.CommonResult;

/**
 * @author nieyan
 * @create 2021-03-16 15:43
 **/
public class StorageFeignServiceFallback implements StorageFeignService {
    @Override
    public CommonResult decrease(Long productId, Integer count) {
        return new CommonResult(500,"error");
    }

    @Override
    public CommonResult checkStorage(Long productId, Integer count) {
        return new CommonResult(500,"error");
    }
}
