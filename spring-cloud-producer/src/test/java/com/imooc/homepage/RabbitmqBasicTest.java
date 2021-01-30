package com.imooc.homepage;

import com.imooc.homepage.helloworld.HelloworldRecv;
import com.imooc.homepage.helloworld.HelloworldSend;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RabbitmqBasicTest {
    // 测试线程池
    protected ExecutorService executorService = Executors.newFixedThreadPool(10);

    // rabbitmq的IP地址
    protected final String rabbitmq_host = "192.168.122.140";
    // rabbitmq的用户名称
    protected final String rabbitmq_user = "hujun";
    // rabbitmq的用户密码
    protected final String rabbitmq_pwd = "hujun";


}
