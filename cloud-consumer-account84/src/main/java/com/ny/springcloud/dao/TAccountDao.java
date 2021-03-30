package com.ny.springcloud.dao;

import com.ny.springcloud.entities.TAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TAccountDao {
    int deleteByPrimaryKey(Long id);

    int insert(TAccount record);

    int insertSelective(TAccount record);

    TAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TAccount record);

    int updateByPrimaryKey(TAccount record);

    int decrease(@Param("userId") Long userId, @Param("money") Long money);

    long checkAccount(@Param("userId") Long userId, @Param("money") Long money);
}