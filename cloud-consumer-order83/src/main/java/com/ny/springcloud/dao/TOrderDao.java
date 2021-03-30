package com.ny.springcloud.dao;


import com.ny.springcloud.entities.TOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TOrderDao {
    int deleteByPrimaryKey(Long id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
}