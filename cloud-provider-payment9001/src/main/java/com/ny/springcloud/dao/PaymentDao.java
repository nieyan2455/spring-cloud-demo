package com.ny.springcloud.dao;

import com.ny.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    int add(Payment payment);

    Payment getPayment(Long id);
}
