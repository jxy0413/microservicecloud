package com.atguigu.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther jxy
 * @Date 2020-07-23
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced //Ribbon是实现负载均衡的工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RandomRule(); //到达目的后，用我们重新选择的随机算法默认的轮询
    }
}
