package com.riskeys.quartz.quartz.job;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component("testJob02")
@Transactional
public class TestJob02 {

    public void execute() {
        System.out.println("-------------------TestJob02任务执行开始-------------------");
        System.out.println(LocalDateTime.now());
        System.out.println("-------------------TestJob02任务执行结束-------------------");
    }
}