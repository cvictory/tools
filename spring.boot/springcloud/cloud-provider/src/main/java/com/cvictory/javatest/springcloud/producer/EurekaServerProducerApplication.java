package com.cvictory.javatest.springcloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cvictory ON 2018/7/27
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServerProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerProducerApplication.class, args);
    }

}

