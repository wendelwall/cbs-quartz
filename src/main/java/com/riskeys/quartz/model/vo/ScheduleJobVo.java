package com.riskeys.quartz.model.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author ：sunrise
 * @description ：
 * @copyright ：	Copyright 2019 yowits Corporation. All rights reserved.
 * @create ：2019/8/23 23:01
 */
@Data
public class ScheduleJobVo {

    /**
     * 任务名称
     */
    @NotBlank(message = "任务名称不能为空")
    private String jobName;

    /**
     * cron表达式
     */
    @NotBlank(message = "cron表达式不能为空")
    private String cronExpression;

    /**
     * 服务名称
     */
    @NotBlank(message = "服务名称不能为空")
    private String beanName;

    /**
     * 方法名称
     */
    @NotBlank(message = "方法名称不能为空")
    private String methodName;

    /**
     * 状态 1.启动 2.暂停
     */
    private int status;
}
