package com.byron.eva.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description: 定时JOB执行
 *
 * @Author: fanmingtao
 * @Date: 2019/1/29
 */
@Slf4j
@Component
public class ScheduleJob {

    @Scheduled(cron = "* * * * * ?")
    public void cronTimeTask() {
        //TO DO SOMETHING
    }

    @Async
    @Scheduled(fixedRate = 1000 * 5, initialDelay = 1000 * 10)
    public void fixedRateTask() {
        //TO DO SOMETHING
    }

    @Async
    @Scheduled(cron = "0/10 * * * * *")
    public void executeAsync() {
        //TO DO SOMETHING
    }
}
