package com.xxx.xxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liushuang on 9/26/16.
 */
@Service
public class ExampleService {
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;


    @Autowired
    public ExampleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }
}
