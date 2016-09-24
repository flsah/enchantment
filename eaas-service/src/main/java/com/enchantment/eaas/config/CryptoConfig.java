package com.enchantment.eaas.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by liushuang on 2016/9/24.
 */
@Component
@ConfigurationProperties(prefix = "eaas.crypto")
public class CryptoConfig {
    private String type;
    private String salt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
