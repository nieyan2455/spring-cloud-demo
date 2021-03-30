package com.ny.springcloud.feign;

import com.ny.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "account-service",fallback = AccountFeignServiceFallback.class)
public interface AccountFeignService {
    String prefix = "/service";
    String account_decrease = "/account/decrease";
    String account_check = "/account/check";

    @PostMapping(prefix + account_decrease)
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);

    @PostMapping(prefix + account_check)
    CommonResult checkAccount(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
