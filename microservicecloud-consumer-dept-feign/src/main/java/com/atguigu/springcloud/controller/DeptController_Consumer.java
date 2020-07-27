package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther jxy
 * @Date 2020-07-23
 */
@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {
    //public static final String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private DeptClientService deptClientService;

    @PostMapping("/dept/add")
    public Object add(Dept dept){
        return this.deptClientService.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return this.deptClientService.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
       return this.deptClientService.list();
    }

}
