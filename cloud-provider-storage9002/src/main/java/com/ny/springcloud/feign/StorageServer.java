package com.ny.springcloud.feign;

import com.ny.springcloud.dao.TStorageDao;
import com.ny.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author nieyan
 * @create 2021-03-16 15:53
 **/
@Slf4j
@RestController
public class StorageServer implements StorageFeignService {

    @Resource
    TStorageDao storageDao;

    @Override
    @PostMapping(prefix + storage_decrease)
    public CommonResult decrease(Long productId, Integer count) {
        int decrease = storageDao.decrease(productId, count);
        if (!(decrease > 0)) {
            log.error("更新库存失败");
            return new CommonResult(500, "error");
        }

        return new CommonResult(200, "success");
    }

    @Override
    public CommonResult checkStorage(Long productId, Integer count) {
        long l = storageDao.checkStorage(productId, count);
        if (l > 0) {
            return new CommonResult(200, "");
        }
        return new CommonResult(500, "库存不足");
    }
}
