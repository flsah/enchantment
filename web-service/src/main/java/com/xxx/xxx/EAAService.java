package com.xxx.xxx;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liushuang on 9/26/16.
 */
public class EAAService {
    private static final Logger L = Logger.getLogger(EAAService.class.getName());

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    public EAAService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }

    public String login(String userName) {
        return restTemplate.getForObject(serviceUrl + "/user/auth",
                String.class, userName);
    }
}
