package com.riskeys.quartz.controller;


import com.riskeys.quartz.domain.ScheduleJob;
import com.riskeys.quartz.model.vo.ScheduleJobVo;
import com.riskeys.quartz.service.ScheduleJobService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wendel
 * @since 2019-01-28
 */
@RestController
@RequestMapping("/job")
public class ScheduleJobController {

    @Autowired
    private ScheduleJobService jobService;

    @GetMapping(value = "/hello")
    public String helloSpringBoot() {
        return "Hello quartz!";
    }

//    @GetMapping("/add")
//    public String add() {
//        ScheduleJob job = new ScheduleJob();
//        job.setJobName("任务02");
//        job.setCronExpression("0/2 * * * * ?");
//        job.setBeanName("testJob02");
//        job.setMethodName("execute");
//        jobService.add(job);
//        return "新增定时任务成功";
//    }

    /**
     * 新增定时任务
     * @param vo
     */
    @PostMapping("/add")
    public void add(@RequestBody @Valid ScheduleJobVo vo) {
        ScheduleJob job = new ScheduleJob();
        BeanUtils.copyProperties(vo, job);
        if(vo.getStatus() == 0){
            job.setStatus(1);
        }
        LocalDateTime currDate = LocalDateTime.now();
        job.setCreatedTime(currDate);
        job.setUpdatedTime(currDate);
        job.setCreatorId(1);
        job.setCreatorName("system");
        jobService.add(job);
    }

    @GetMapping("/start/{id}")
    public String start(@PathVariable("id") Integer id) {
        jobService.start(id);
        return "启动定时任务成功";
    }

    @GetMapping("/pause/{id}")
    public String pause(@PathVariable("id") Integer id) {
        jobService.pause(id);
        return "暂停定时任务成功";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        jobService.delete(id);
        return "删除定时任务成功";
    }

    @GetMapping("/startAllJob")
    public String startAllJob() {
        jobService.startAllJob();
        return "启动所有定时任务成功";
    }

    @GetMapping("/pauseAllJob")
    public String pauseAllJob() {
        jobService.pauseAllJob();
        return "暂停所有定时任务成功";
    }
}

