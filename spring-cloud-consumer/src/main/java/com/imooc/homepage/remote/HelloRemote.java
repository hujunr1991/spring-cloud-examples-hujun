package com.imooc.homepage.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by summer on 2017/5/11.
 */
@FeignClient(name = "spring-cloud-producer", fallback = HelloClientHystrix.class)
public interface HelloRemote {

    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);


}
