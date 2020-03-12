package com.zhht.test;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhht.service.RedisService;

/**
 * 
* @ClassName: JedisClusterJunit  
* <p>Description: jedis集群模式使用  
* 问题 针对不同的值，获取结果不同 有的数据返回 
* redis.clients.jedis.exceptions.JedisClusterMaxAttemptsException: No more cluster attempts left.
* 很是疑惑，难道是搭建环境的问题？
*   </p>
* @author  frankman
* @date 2020年3月11日 下午3:43:39  
*
 */
public class JedisClusterJunit extends BaseUnitTest{
	private Logger logger = LoggerFactory.getLogger(JedisClusterJunit.class);
	
	@Autowired
	private RedisService jedisClusterService;
	
	@Test
	public void clusterGetKey(){
		jedisClusterService.set("name", "clusterName");
		logger.info("jedisClusterGetKey {}",jedisClusterService.get("sssname"));
	}
	public void setJedisClusterService(RedisService jedisClusterService) {
		this.jedisClusterService = jedisClusterService;
	}

}
