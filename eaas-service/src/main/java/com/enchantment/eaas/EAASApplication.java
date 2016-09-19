package com.enchantment.eaas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.logging.Logger;

@EnableAutoConfiguration
@ComponentScan("com.enchantment.eaas")
@EnableDiscoveryClient
@PropertySource("classpath:application.properties")
public class EAASApplication {

	protected Logger logger = Logger.getLogger(EAASApplication.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.setProperty("spring.config.name", "eaas-server");
		SpringApplication.run(EAASApplication.class, args);
	}
}
