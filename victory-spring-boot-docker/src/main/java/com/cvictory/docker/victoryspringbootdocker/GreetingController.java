package com.cvictory.docker.victoryspringbootdocker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author cvictory ON 2019-10-15
 */
@RestController
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        return "greeting ! (From hostName: " + address.getHostName() + " , hostAddress: " + address.getHostAddress() + " )";
    }
}
