package com.springmvc.controller;

import com.github.pagehelper.PageInfo;
import com.springmvc.entity.Hello;
import com.springmvc.exception.CustomException;
import com.springmvc.service.HelloService;
import com.springmvc.utils.JsonUtil;
import com.springmvc.utils.PageUtil;
import com.springmvc.utils.PagedResult;
import com.springmvc.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
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
        PageUtil.startPages(pageNo, pageSize, "id desc");
        log.info("当前线程为：{}", Thread.currentThread().getName());
        String p = redisUtil.get(pageNo + "-" + pageSize);
        log.error("缓存中数据为：" + p);
        List<Hello> select = null;
        if (p == null) {
            log.error("查询数据库");
            select = helloService.select(hello);
            redisUtil.setEx(pageNo + "-" + pageSize, JsonUtil.objectToJson(select), 30, TimeUnit.SECONDS);
            log.error("放入缓存成功...");
        } else {
            log.error("获取缓存内容");
            select = (List<Hello>) JsonUtil.jsonToList(p);
        }
        PageInfo<Hello> page = null;
        page = new PageInfo<>(select);
        return PageUtil.toPagedResult(page);
    }

    //异步
    @GetMapping("/callable-hello-world")
    public CompletionStage<String> completionStage() {
        final long startTime = System.currentTimeMillis();

        return CompletableFuture.supplyAsync(() -> {
            long costTime = System.currentTimeMillis() - startTime;
            return "Hello,World"; // 异步执行结果
        });
    }

    @RequestMapping(value = "/insert", produces = "application/json;charset=UTF-8")
    public int insert() {
        for (int i = 0; i < 100; i++) {
            Hello s = new Hello();
            s.setName(UUID.randomUUID().toString().replace("-", ""));
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
