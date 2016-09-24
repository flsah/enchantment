package com.enchantment.eaas;

import com.enchantment.eaas.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * <p>Redis Cache Operation Service</p>
 *
 * Created by liushuang on 9/22/16.
 */
@Component
public class CacheUtil {
    private Jedis jedis;

    @Autowired
    public CacheUtil(RedisConfig redisConfig) {
//        EAASConfiguration.Redis redisConfig = config.getRedis();
        jedis = new Jedis(redisConfig.getHost(), redisConfig.getPort());
    }

    public void push(String key, String val) {
        String status = jedis.set(key, val);
    }

    public void push (String key, List<String> val) {
        String[] vals = new String[val.size()];
        val.toArray(vals);

        Long status = jedis.lpush(key, vals);
    }

    public void push (String key, Map<String, String> val) {
        String status = jedis.hmset(key, val);
    }

    public void push (String key, Number val) {
        jedis.set(key, val.toString());
    }

    public String get(String key) {
        return jedis.get(key);
    }
}
