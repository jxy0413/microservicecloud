package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallback.class)
@RequestMapping("/dept")
@Service
public interface DeptClientService {
    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept);

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @GetMapping("/list")
    public List<Dept> list();

}
