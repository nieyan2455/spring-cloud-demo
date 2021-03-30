package com.ny.springcloud.feign;

import com.ny.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/*
 * @author nieyan
 * @create 2021-03-15 16:46
 */

@Component
public class PaymentFeignServiceFallback implements PaymentFeignService{
    @Override
    public Payment get(Long id) {
        return null;
    }

    @Override
    public int add(Payment payment) {
        return 0;
    }
}
