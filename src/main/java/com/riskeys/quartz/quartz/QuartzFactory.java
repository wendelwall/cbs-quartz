package com.riskeys.quartz.quartz;

import com.alibaba.fastjson.JSONObject;
import com.riskeys.quartz.domain.ScheduleJob;
import com.riskeys.quartz.service.remote.CallService;
import com.riskeys.quartz.service.FeignInvokeService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class QuartzFactory implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //获取调度数据
        ScheduleJob scheduleJob = (ScheduleJob) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");

//        //获取对应的Bean
//        Object object = SpringUtil.getBean(scheduleJob.getBeanName());
//        try {
//            //利用反射执行对应方法
//            Method method = object.getClass().getMethod(scheduleJob.getMethodName());
//            method.invoke(object);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            log.info("==============开始执行任务 "+scheduleJob.getJobName()+" ==============");
            log.info("==============任务参数 "+ JSONObject.parseObject(scheduleJob.getBody()) +" ==============");
            FeignInvokeService.targetInvoke(scheduleJob.getUrl(), CallService.class, p -> p.callTask(JSONObject.parseObject(scheduleJob.getBody())));
            log.info("==============任务执行结束 "+scheduleJob.getJobName()+" ==============");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
