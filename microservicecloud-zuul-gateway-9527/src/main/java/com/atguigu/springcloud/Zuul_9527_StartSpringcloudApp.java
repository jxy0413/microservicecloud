package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther jxy
 * @Date 2020-07-26
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringcloudApp {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StartSpringcloudApp.class,args);
    }
}
