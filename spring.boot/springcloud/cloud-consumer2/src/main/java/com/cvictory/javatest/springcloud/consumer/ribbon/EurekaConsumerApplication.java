package com.cvictory.javatest.springcloud.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author cvictory ON 2018/7/27
 */
@EnableDiscoveryClient //开启服务发现的能力
@SpringBootApplication
public class EurekaConsumerApplication {

    @Bean //定义REST客户端，RestTemplate实例
    @LoadBalanced
        //开启负债均衡的能力
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }
}
