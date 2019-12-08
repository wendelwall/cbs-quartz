package com.riskeys.quartz.quartz;

import com.alibaba.fastjson.JSONObject;
import com.riskeys.quartz.domain.ScheduleJob;
import com.riskeys.quartz.service.FeignInvokeService;
import com.riskeys.quartz.service.remote.CallService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

@Component
@PersistJobDataAfterExecution
//禁止并发执行(Quartz不要并发地执行同一个job定义（这里指一个job类的多个实例）)
@DisallowConcurrentExecution
@Slf4j
public class QuartzFactory implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //获取调度数据
        ScheduleJob scheduleJob = (ScheduleJob) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");
//        RedissonClient redisClient = SpringUtils.getBean(RedissonClient.class);
//        RLock fairLock = redisClient.getFairLock(String.valueOf(scheduleJob.getId()));

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
//            fairLock.tryLock();
            // 支持过期解锁功能, 10秒钟以后自动解锁,无需调用unlock方法手动解锁
//            boolean res = fairLock.tryLock(10, TimeUnit.SECONDS);
//            // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
//            boolean res = fairLock.tryLock(100, 10, TimeUnit.SECONDS);
//            if(res){
//                log.info("加锁成功");
//            }
            log.info("==============开始执行任务 "+scheduleJob.getJobName()+" ==============");
            log.info("==============任务参数 "+ JSONObject.parseObject(scheduleJob.getBody()) +" ==============");
            FeignInvokeService.targetInvoke(scheduleJob.getUrl(), CallService.class, p -> p.callTask(JSONObject.parseObject(scheduleJob.getBody())));
            log.info("==============任务执行结束 "+scheduleJob.getJobName()+" ==============");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            fairLock.unlock();
//            log.info("解锁成功");
        }
    }
}
