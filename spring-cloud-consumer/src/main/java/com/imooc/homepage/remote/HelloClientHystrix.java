package com.imooc.homepage.remote;

import org.springframework.stereotype.Component;

/**
 * <h1>熔断降级</h1>
 * Created by Qinyi.
 */
@Component
public class HelloClientHystrix implements HelloRemote {

    @Override
    public String hello(String name) {
        return "sorry, the app is down" + name;
    }
}
