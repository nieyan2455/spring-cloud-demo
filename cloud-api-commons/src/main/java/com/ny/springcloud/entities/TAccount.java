package com.ny.springcloud.entities;

import java.io.Serializable;
import lombok.Data;

/**
 * t_account
 * @author 
 */
@Data
public class TAccount implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private Long total;

    /**
     * 已用余额
     */
    private Long used;

    /**
     * 剩余可用额度
     */
    private Long residue;

    private static final long serialVersionUID = 1L;
}