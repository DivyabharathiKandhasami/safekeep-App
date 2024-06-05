package com.userportal.safekeep.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class MyService {

/*	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	private String key;
	private String value;
	@Autowired
	EmailService emailservice;
	// changed
	public void setData(String key, String value) {
	ValueOperations<String, Object> ops = redisTemplate.opsForValue();
	ops.set(key, value);
	}
	/*
	 * public void setData(String key, String value){ ValueOperations<String,
	 * Object> ops = redisTemplate.opsForValue(); ops.set(key, value); }
	 */
	/*public String getData(String key) {
		ValueOperations<String, Object> ops = redisTemplate.opsForValue();
		return (String) ops.get(key);
	}
	/*
	 * public void set(String key, String value) { this.key = key;
	 * this.setValue(value); setData(this.key, this.getValue()); }
	 */
	// generate otp for the In-memory storage
	/*private static String generateOtp() {
		return String.valueOf(new Random().nextInt(900000) + 100000);
	}
	public String get(String key) {
		this.key = key;
		return getData(this.key);
	}
	public String getValue() {
		return getValue();
	}
	// changed
	public void setValue(String value) {
		this.value = value;
	}
	public void set(String key) {
		this.key = key;
		this.setValue(value);
		setData(this.key, this.value);
	}
}*/
	 @Autowired
	    private RedisTemplate<String, Object> redisTemplate;

	    public void setData(String key, String value) {
	        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
	        ops.set(key, value);
	    }

	    public String getData(String key) {
	        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
	        return (String) ops.get(key);
	    }

	    public void set(String key, String value) {
	        setData(key, value);
	    }

	    public String get(String key) {
	        return getData(key);
	    }
}
	
	
