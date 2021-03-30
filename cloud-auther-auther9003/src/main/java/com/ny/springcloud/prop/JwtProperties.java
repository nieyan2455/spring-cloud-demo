package com.ny.springcloud.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author nieyan
 * @create 2021-03-10 15:42
 **/
@ConfigurationProperties("ny.token")
@Data
public class JwtProperties {
    private String signKey;
}
