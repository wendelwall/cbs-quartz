package com.riskeys.quartz.quartz.job;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component("testJob01")
@Transactional
public class TestJob01 {

    public void execute() {
        System.out.println("-------------------TestJob01任务执行开始-------------------");
        System.out.println(LocalDateTime.now());
        System.out.println("-------------------TestJob01任务执行结束-------------------");
    }
}
