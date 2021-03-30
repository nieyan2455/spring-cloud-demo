package com.ny.springcloud.service.impl;


import com.ny.springcloud.dao.TOrderDao;
import com.ny.springcloud.entities.CommonResult;
import com.ny.springcloud.entities.TOrder;
import com.ny.springcloud.feign.AccountFeignService;
import com.ny.springcloud.feign.StorageFeignService;
import com.ny.springcloud.service.IOrderService;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransaction;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * @author nieyan
 * @create 2021-03-16 15:33
 **/
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private TOrderDao orderDao;
    @Resource
    private StorageFeignService storageFeignService;
    @Resource
    private AccountFeignService accountFeignService;

    private ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);

    @Override
    public CommonResult checkOrder(TOrder order) {
        CommonResult checkStorage = storageFeignService.checkStorage(order.getProductId(), order.getCount());
        if (!checkStorage.isSuccess()) {
            return checkStorage;
        }
        CommonResult checkAccount = accountFeignService.checkAccount(order.getUserId(), order.getMoney());
        if (!checkAccount.isSuccess()) {
            return checkAccount;
        }
        return new CommonResult(200, "");
    }

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GlobalTransactional
    public CommonResult createOrder(TOrder order) {

        GlobalTransaction globalTransaction = GlobalTransactionContext.getCurrentOrCreate();
        log.info("===创建订单 start===");
        orderDao.insert(order);
        try {
            log.info("===减少库存 start===");
            CommonResult storeResult = storageFeignService.decrease(order.getProductId(), order.getCount());
            if (!storeResult.isSuccess()) {
                globalTransaction.rollback();
                return storeResult;
            }
            log.info("===减少库存 end===");


            log.info("===扣钱 start===");
            CommonResult accountResult = accountFeignService.decrease(order.getUserId(), order.getMoney());
            if (!accountResult.isSuccess()) {
                globalTransaction.rollback();
                return accountResult;
            }
            log.info("===扣钱 end===");

/*
        CompletionService<CommonResult> completionService = new ExecutorCompletionService<CommonResult>(threadPoolExecutor);
        Future<CommonResult> future = completionService.submit(() -> {
            {
                return storageFeignService.decrease(order.getProductId(), order.getCount());
            }
        });
        Future<CommonResult> future1 = completionService.submit(() -> {
            return accountFeignService.decrease(order.getUserId(), order.getMoney());
        });
        try {
            for (int i = 0; i < 2; i++) {
                CommonResult result = completionService.take().get();
                if (result.getCode() != 200) {
                    throw new RuntimeException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

            log.info("===修改订单状态 start===");
            TOrder updateRecord = new TOrder();
            updateRecord.setId(order.getId());
            updateRecord.setStatus(1);
            orderDao.updateByPrimaryKeySelective(updateRecord);
            log.info("===修改订单状态 end===");

        } catch (TransactionException e) {
            e.printStackTrace();
        }
        log.info("===创建订单 end===");
        return new CommonResult(200, "success");
    }
}
