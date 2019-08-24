package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.Hello;
import com.springmvc.service.HelloService;
import com.springmvc.utils.BeanUtil;
import com.springmvc.utils.PagedResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：qmf
 * @date ：Created in 2019/8/24 10:26
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public PagedResult hello(String pageNo, String pageSize) {
        Hello hello = new Hello();
        int pageN = StringUtils.isEmpty(pageNo) ? 0 : Integer.parseInt(pageNo);
        int pageP = StringUtils.isEmpty(pageSize) ? 20 : Integer.parseInt(pageSize);
        PageHelper.startPage(pageN, pageP);//关键步骤
        List<Hello> select = helloService.select(hello);
        PageInfo<Hello> page = new PageInfo<Hello>(select);
        log.info("哈哈");
        return BeanUtil.toPagedResult(page);
    }

    @RequestMapping(value = "/insert", produces = "application/json;charset=UTF-8")
    public int insert() {
        for (int i = 0; i < 100; i++) {
            Hello s = new Hello();
            s.setName("啥" + i);
            helloService.insert(s);
        }
        return 1;
    }


}
