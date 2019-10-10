package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.Hello;
import com.springmvc.exception.CustomException;
import com.springmvc.service.HelloService;
import com.springmvc.utils.BeanUtil;
import com.springmvc.utils.JsonUtil;
import com.springmvc.utils.PagedResult;
import com.springmvc.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ：qmf
 * @date ：Created in 2019/8/24 10:26
 * @description：测试
 * @modified By：
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public PagedResult hello(String pageNo, String pageSize) {
        Hello hello = new Hello();
        int pageN = StringUtils.isEmpty(pageNo) ? 1 : Integer.parseInt(pageNo);
        int pageP = StringUtils.isEmpty(pageSize) ? 20 : Integer.parseInt(pageSize);
        PageHelper.startPage(pageN, pageP, "id desc");//关键步骤
        PageInfo<Hello> page = null;
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

    @RequestMapping("/test3")
    public String test3(Integer num) {
        // TODO 演示需要，实际上参数是否为空通过 @RequestParam(required = true)  就可以控制
        if (num == null) {
            throw new CustomException(400, "num不能为空");
        }
        int i = 10 / num;
        return "result:" + i;
    }


}
