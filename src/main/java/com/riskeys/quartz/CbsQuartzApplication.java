package com.riskeys.quartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.riskeys")
@ServletComponentScan
@EnableFeignClients
@MapperScan("com.riskeys.quartz.mapper")
public class CbsQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbsQuartzApplication.class, args);
    }

}

