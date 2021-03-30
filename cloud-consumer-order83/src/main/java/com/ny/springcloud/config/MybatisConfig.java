package com.ny.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author nieyan
 * @create 2021-03-16 17:43
 **/
@Configuration
@MapperScan("com.ny.springcloud.dao")
public class MybatisConfig {
}
