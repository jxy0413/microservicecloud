package springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.service.DeptService;

import java.util.List;

/**
 * @Auther jxy
 * @Date 2020-07-23
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;


    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod="processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.get(id);
        if(dept==null){
            throw new RuntimeException("该ID:"+id+"没有对应的信息");
        }
        return dept;
    }


    public Dept processHystrix_Get(@PathVariable("id")Long id){
        return new Dept().setDeptno(id).setDname("该ID"+id+"没有对应的信息，null--@HystrixCommand")
                .setDb_source("no this is in DataBase");
    }



    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.list();
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("******"+services);

        List<ServiceInstance> microservicecloud_dept = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        System.out.println(microservicecloud_dept);
        for(ServiceInstance s:microservicecloud_dept){
            System.out.println(s.getServiceId()+"\t"+s.getHost()+"\t"+s.getPort()+"\t"+s.getUri());
        }
        return this.discoveryClient;
    }
}
