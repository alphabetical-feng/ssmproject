package com.springmvc.dao;

import com.springmvc.entity.Hello;

import java.util.List;

public interface HelloMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hello record);

    int insertSelective(Hello record);

    Hello selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hello record);

    int updateByPrimaryKey(Hello record);

    List<Hello> select(Hello hello);
}