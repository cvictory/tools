package com.cvictory.javatest.springcloud.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cvictory ON 2018/7/27
 */
@RestController
public class ServiceInstanceRestController {

//    private static final Logger logger = LoggerFactory.getLogger(ServiceInstanceRestController.class);

    @Autowired
    private Registration registration; //服务发现客户端

    @GetMapping(value = "/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        Integer r = a + b;
        System.out.println("/add, host:" + registration.getHost() + ", service_id:" + registration.getServiceId() + ", result:" + r);
        return r;
    }
}
