package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther jxy
 * @Date 2020-07-23
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan("com.atguigu.springcloud")
@EnableFeignClients({"com.atguigu.springcloud"})
public class DeptConsumerDeptFeign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDeptFeign.class,args);
    }
}
