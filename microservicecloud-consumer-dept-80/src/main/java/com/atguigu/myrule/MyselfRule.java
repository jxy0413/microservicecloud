package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther jxy
 * @Date 2020-07-24
 */
@Configuration
public class MyselfRule {
     @Bean
     public IRule myRule(){
        return new RandomRule();  //Ribbon默认是轮询，我自定义为随机
     }
}
