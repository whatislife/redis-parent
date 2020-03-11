package com.zhht.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhht.util.JedisSentinelPoolUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
/**
 * 
* @ClassName: JedisJunit  
* <p>Description: redis sentinel  </p>
* @author  frankman
* @date 2020年3月6日 下午4:18:24  
*
 */
public class JedisSentinelPoolJunit {
	private JedisSentinelPool jedisSentinelPool ; 
	private Jedis jedis;
	@Before
	public void init() throws Exception {
		System.out.println("init()");
		jedisSentinelPool = JedisSentinelPoolUtil.getJedisPoolInstance();
		jedis = jedisSentinelPool.getResource();
	}

	@After
	public void destroy() throws Exception {
		System.out.println("destroy()");
		JedisSentinelPoolUtil.release(jedisSentinelPool);
	}
	@Test
	public void jedisPing(){
		//System.out.println("jedis ping .... " + jedis.info());
		//System.out.println("==============");
		System.out.println("----"+jedis.get("name"));
	}
}
