package com.ny.springcloud.feign;

import com.ny.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "storage-service", fallback = StorageFeignServiceFallback.class)
public interface StorageFeignService {
    String prefix = "/service";
    String storage_decrease = "/storage/decrease";
    String check_decrease = "/storage/check";

    @PostMapping(value = prefix + storage_decrease)
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

    @PostMapping(value = prefix + check_decrease)
    CommonResult checkStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
