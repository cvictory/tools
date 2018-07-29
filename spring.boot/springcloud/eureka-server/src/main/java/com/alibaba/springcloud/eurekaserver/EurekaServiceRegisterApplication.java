package com.cvictory.javatest.springcloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author cvictory ON 2018/7/26
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceRegisterApplication.class, args);
    }
}
