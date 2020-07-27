package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther jxy
 * @Date 2020-07-26
 */
@Component
public class DeptClientServiceFallback implements FallbackFactory<DeptClientService>{
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该ID:"+id+"没有对应响应")
                        .setDb_source("no this database in Mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
