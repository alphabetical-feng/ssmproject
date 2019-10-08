package com.springmvc.service.Impl;

import com.springmvc.dao.HelloMapper;
import com.springmvc.entity.Hello;
import com.springmvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：qmf
 * @date ：Created in 2019/8/24 14:17
 * @description：
 * @modified By：
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper mapper;

    public List<Hello> select(Hello hello) {
        return mapper.select(hello);
    }

    public int insert(Hello record) {
        return mapper.insert(record);
    }


}
