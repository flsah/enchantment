package com.xxx.xxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

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

    public ResponseEntity login(String userName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(userName, headers);

        return restTemplate.postForObject(
                serviceUrl.concat("/v1/user/auth"),
                entity,
                ResponseEntity.class);
    }
}
