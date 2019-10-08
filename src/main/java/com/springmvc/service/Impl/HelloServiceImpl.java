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
        List<Hello> helloList = mapper.select(hello);
        return helloList;
    }

    public int insert(Hello record) {
//        int i = mapper.updateByPrimaryKeySelective(record);
//        System.out.println(i);
//        if (i==0)
//            throw new RuntimeException();
//        record.setId(1290L);
        int i = mapper.insert(record);
        return i;
    }


}
