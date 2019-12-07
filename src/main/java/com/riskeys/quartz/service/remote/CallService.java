package com.riskeys.quartz.service.remote;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ：sunrise
 * @description ：动态url远程调用
 * @copyright ：	Copyright 2019 yowits Corporation. All rights reserved.
 * @create ：2019/8/2 21:23
 */
@FeignClient(name = "UserService")
public interface CallService {

    @PostMapping
    JSONObject callTask(@RequestBody JSONObject body);
}
