package com.userportal.safekeep.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class MyCom {
	private final RedisTemplate<String, Object> redisTemplate;
	private final ValueOperations<String, Object> valueOperations;

	@Autowired
	public MyCom(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.valueOperations = redisTemplate.opsForValue();
	}

	public void setValue(String key, Object value) {
		valueOperations.set(key, value);
	}

	public Object getValue(String key) {
		return valueOperations.get(key);
	}
}
