package com.springmvc.service;

import com.springmvc.entity.Hello;

import java.util.List;

/**
 * @author ：qmf
 * @date ：Created in 2019/8/24 13:49
 * @description：
 * @modified By：
 */
public interface HelloService {
    List<Hello> select(Hello hello);
    int insert(Hello record);
}
