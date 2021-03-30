package com.ny.springcloud.feign;

import com.ny.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "payment-service")
public interface PaymentFeignService {
    String GET_PAYMENT = "/api/payment/get/{id}";
    String ADD_PAYMENT = "/api/payment/add";

    @GetMapping(GET_PAYMENT)
    Payment get(@PathVariable("id") Long id);

    @GetMapping(ADD_PAYMENT)
    int add(Payment payment);
}
