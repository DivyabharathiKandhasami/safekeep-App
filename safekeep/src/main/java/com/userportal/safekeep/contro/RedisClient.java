package com.userportal.safekeep.contro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.exceptions.JedisException;

public class RedisClient {
	private Jedis jedis;
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;
	
	public void setKeyValue(String key, String value) {
        try {
        	jedis.set(key, redisTemplate.getValueSerializer());
        } catch (JedisException e) {
            System.err.println("Error setting key-value pair: " + e.getMessage());
        }
    }

    public String getKeyValue(String key) {
        try {
        	byte[] bytes = jedis.get(key.getBytes());
        	if (bytes != null) {
        	    Object value = redisTemplate.getValueSerializer().deserialize(bytes);
        	    // do something with the value
        	} else {
        	    // handle the case where the key is not found
        	}
        
        }
        catch (JedisException e) {
            System.err.println("Error getting key-value pair: " + e.getMessage());
            return null;
        }
	
        
	
	
	
	
	
	

}
