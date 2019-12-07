package com.riskeys.quartz.service;

import com.riskeys.quartz.util.SpringUtil;

import java.util.function.Function;

/**
 * @author ：sunrise
 * @description ：feign 动态url执行方法
 * @copyright ：	Copyright 2019 riskeys Corporation. All rights reserved.
 * @create ：2019/8/4 0:02
 */
public class FeignInvokeService {

    /**
     * 动态创建Feign调用client对象
     * @param url       远程调用url
     * @param apiType   feign接口类
     * @param <T>
     * @return          返回feign-client对象
     */
    public static <T> T getBean(String url, Class<T> apiType){
        FeignService feignService = SpringUtil.getBean(FeignService.class);
        return feignService.createClientByUrl(apiType, url);
    }

    /**
     * 动态调用FeignClient对象方法
     * @param url       远程调用url
     * @param apiType   feign接口类
     * @param mapper    目标方法
     * @param <T>       目标对象class
     * @param <R>       目标方法执行完成返回的对象类型
     * @return          目标方法执行完成返回的对象
     */
    public static <T, R> R targetInvoke(String url, Class<T> apiType, Function<T, R> mapper){
        return mapper.apply(FeignInvokeService.getBean(url, apiType));
    }
}
