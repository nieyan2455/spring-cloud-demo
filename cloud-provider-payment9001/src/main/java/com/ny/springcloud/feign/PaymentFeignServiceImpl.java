package com.ny.springcloud.feign;

import com.ny.springcloud.entities.Payment;
import com.ny.springcloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nieyan
 * @create 2021-03-09 14:13
 **/
@RestController
public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Autowired
    private IPaymentService iPaymentService;

    @Override
    @GetMapping(GET_PAYMENT)
    public Payment get(Long id) {
        return iPaymentService.getPayment(id);
    }

    @Override
    @GetMapping(ADD_PAYMENT)
    public int add(Payment payment) {
        return iPaymentService.add(payment);
    }


}
