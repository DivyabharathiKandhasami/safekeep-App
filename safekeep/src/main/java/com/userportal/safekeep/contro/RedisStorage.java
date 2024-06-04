package com.userportal.safekeep.contro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;

import com.userportal.safekeep.service.MyService;

public class RedisStorage {
	@Autowired
	MyService myservice;

	private Jedis jedis;

	public RedisStorage() {
		jedis = new Jedis();
	}

	public void storeData(String key, String value) {
		myservice.set(key);
	}

	public void getData(String key) {

		myservice.get(key);
	}

}
