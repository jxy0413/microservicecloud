package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther jxy
 * @Date 2020-07-23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //入住发现
@EnableCircuitBreaker //开启熔断器
public class DeptProvider8001Hystrix_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001Hystrix_App.class,args);
    }
}
