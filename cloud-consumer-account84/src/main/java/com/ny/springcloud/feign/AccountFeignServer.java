package com.ny.springcloud.feign;

import com.ny.springcloud.dao.TAccountDao;
import com.ny.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author nieyan
 * @create 2021-03-16 16:27
 **/
@RestController
public class AccountFeignServer implements AccountFeignService {
    @Resource
    private TAccountDao accountDao;

    @Override
    @PostMapping(prefix + account_decrease)
    public CommonResult decrease(Long userId, Long money) {
        accountDao.decrease(userId, money);
        return new CommonResult(200, "success");
    }

    @Override
    public CommonResult checkAccount(Long userId, Long money) {
        long l = accountDao.checkAccount(userId, money);
        if (l > 0) {
            return new CommonResult(200, "");
        }
        return new CommonResult(500, "余额不足");
    }
}
