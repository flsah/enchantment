package com.xxx.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan
public class WebServer {
	/**
	 * EAAS services url
	 */
	public static final String EAAS_SERVICE_URL = "http://EAAS-SERVICE";

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
	}

	/**
	 * A customized RestTemplate that has the ribbon load balancer build in.
	 * Note that prior to the "Brixton"
	 *
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public EAAService eaaService() {
		return new EAAService(EAAS_SERVICE_URL);
	}

	@Bean
	public ExampleController exampleController() {
		return new ExampleController(eaaService());
	}

}
