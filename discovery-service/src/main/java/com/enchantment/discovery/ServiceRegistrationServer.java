package com.enchantment.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by liushuang on 2016/9/6.
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistrationServer {

    public static void main(String[] args) {
        // Tell Boot to look for discovery-server.yml
        System.setProperty("spring.config.name", "discovery-server");
        SpringApplication.run(ServiceRegistrationServer.class, args);
    }
}
