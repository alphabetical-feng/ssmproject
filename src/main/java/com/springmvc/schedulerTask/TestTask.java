package com.springmvc.schedulerTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @author ：qmf
 * @date ：Created in 2019/10/11 7:48
 * @description：测试定时任务
 * @modified By：
 */
@Slf4j
@Service
public class TestTask {

    @Scheduled(cron = "0/5 * * * * ? ")
    public void quartz() {
        log.error("定时任务执行：{}", LocalTime.now());
    }

}
