/*
 * @url http://cetcsc.cetc.com.cn
 * Copyright (c) 2015-2020 All Rights Reserved.
 */

package com.hujun.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO java类作用描述
 * @author hujun [hu.junr151@163.com]
 * @date   2021/1/30 10:28
 * @since  1.0
 */
@Slf4j
@Configuration
public class DruidConfiguration {

    /**
     * 注册ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> registrationBean() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // APP初始化参数配置，initParams 白名单,多个ip逗号隔开
        bean.addInitParameter("allow", "127.0.0.1");
        /* IP黑名单 (存在共同时，deny优先于allow)
        如果满足deny的话提示:Sorry, you are not permitted to view this page.
        bean.addInitParameter("deny", "192.168.1.73"); 登录查看信息的账号密码 */

        bean.addInitParameter("loginUsername", "swad");
        bean.addInitParameter("loginPassword", "0xCAFEBABE");
        // 是否能够重置数据.
        bean.addInitParameter("resetEnable", "false");
        return bean;
    }

    /**
     * 注册FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> druidStatFilter() {
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        // 添加过滤规则.
        bean.addUrlPatterns("/*");
        // 添加不需要忽略的格式信息.
        bean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return bean;
    }

}
