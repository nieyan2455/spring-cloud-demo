package com.ny.springcloud.service;

import com.ny.springcloud.entities.CommonResult;
import com.ny.springcloud.entities.TOrder;

public interface IOrderService {
    CommonResult checkOrder(TOrder order);

    CommonResult createOrder(TOrder order);
}
