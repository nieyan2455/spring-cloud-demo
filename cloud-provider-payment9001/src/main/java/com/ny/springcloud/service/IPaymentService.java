package com.ny.springcloud.service;

import com.ny.springcloud.entities.Payment;

public interface IPaymentService {
    int add(Payment payment);

    Payment getPayment(Long id);
}
