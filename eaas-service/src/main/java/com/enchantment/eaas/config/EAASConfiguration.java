package com.enchantment.eaas.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liushuang on 9/22/16.
 */
@Configuration
@EnableConfigurationProperties({RedisConfig.class, CryptoConfig.class})
@ConfigurationProperties(prefix = "eaas")
public class EAASConfiguration {
}
