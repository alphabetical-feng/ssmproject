package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.Hello;
import com.springmvc.service.HelloService;
import com.springmvc.utils.BeanUtil;
import com.springmvc.utils.JsonUtil;
import com.springmvc.utils.PagedResult;
import com.springmvc.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public PagedResult hello(String pageNo, String pageSize) {
        Hello hello = new Hello();
        int pageN = StringUtils.isEmpty(pageNo) ? 1 : Integer.parseInt(pageNo);
        int pageP = StringUtils.isEmpty(pageSize) ? 20 : Integer.parseInt(pageSize);
        PageHelper.startPage(pageN, pageP);//关键步骤
        PageInfo<Hello> page = null;
        try {
            List<Hello> select = helloService.select(hello);
            String p = redisUtil.get("hello-list");
            log.info("缓存中数据为：" + p);
            if (p == null) {
                redisUtil.set("hello-list", JsonUtil.objectToJson(select));
                redisUtil.expire("hello-list", 30, TimeUnit.SECONDS);
                log.info("放入缓存成功...");
            }
            page = new PageInfo<Hello>(select);
            log.info("哈哈");
        } catch (Exception e) {
            log.info(e + "");
        }
        return BeanUtil.toPagedResult(page);
    }

    public static void main(String[] args) {

    }

    @RequestMapping(value = "/insert", produces = "application/json;charset=UTF-8")
    public int insert() {
        int k = 1;
        for (int i = 0; i < 1000; i++) {
            Hello s = new Hello();
            s.setName("测试" + i);
            helloService.insert(s);
        }
        return 1;
    }


}
