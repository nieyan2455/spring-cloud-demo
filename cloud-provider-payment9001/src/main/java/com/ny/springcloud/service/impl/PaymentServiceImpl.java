package com.ny.springcloud.service.impl;


import com.ny.springcloud.entities.Payment;
import com.ny.springcloud.dao.PaymentDao;
import com.ny.springcloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nieyan
 * @create 2021-02-19 15:30
 **/
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentDao.getPayment(id);
    }
}
