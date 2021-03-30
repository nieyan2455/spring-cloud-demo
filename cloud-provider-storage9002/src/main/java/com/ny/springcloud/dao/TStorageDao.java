package com.ny.springcloud.dao;


import com.ny.springcloud.entities.TStorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TStorageDao {
    int deleteByPrimaryKey(Long id);

    int insert(TStorage record);

    int insertSelective(TStorage record);

    TStorage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TStorage record);

    int updateByPrimaryKey(TStorage record);

    int decrease(@Param("productId") Long productId,@Param("count") Integer count);

    long checkStorage(@Param("productId") Long productId,@Param("count") Integer count);
}