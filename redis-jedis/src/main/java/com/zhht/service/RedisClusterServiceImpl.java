package com.zhht.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;

@Service("redisClusterService")
public class RedisClusterServiceImpl implements RedisService{
	
	@Autowired
	private JedisCluster jedisCluster;
	
	@Override
	public void set(String key, String value) {
			jedisCluster.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}
}
