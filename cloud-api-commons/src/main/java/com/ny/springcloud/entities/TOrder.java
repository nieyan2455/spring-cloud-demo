package com.ny.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t_order
 * @author 
 */
@Data
public class TOrder implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额
     */
    private Long money;

    /**
     * 订单状态：0：创建中; 1：已完结
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}