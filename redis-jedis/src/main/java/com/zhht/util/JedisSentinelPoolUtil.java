package com.zhht.util;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.JedisSentinelPool;

/**
 * 
* @ClassName: JedisSentinelPoolUtil  
* <p>Description: sentinel pool方式  
* 如果是连接虚拟机
* https://blog.csdn.net/qq_40259907/article/details/83352570 
* sentinel.config
* sentinel monitor mymaster 192.168.142.129 6379 2
* 红色字体一定要是服务器或者虚拟机的IP地址，不能是127.0.0.1。（本人就犯了这个错误，浪费了一天的时间）
* </p>
* @author  frankman
* @date 2020年3月8日 下午5:11:51  
*
 */
public class JedisSentinelPoolUtil {
	private static volatile JedisSentinelPool jedisSentinelPool = null;
	private static String masterName = "mymaster";
	public JedisSentinelPoolUtil() {
		
	}
	@SuppressWarnings("unused")
	public static JedisSentinelPool getJedisPoolInstance(){
		if(null == jedisSentinelPool){
			synchronized(JedisSentinelPoolUtil.class){
				if(null == jedisSentinelPool){
	                Set<String> sentinels = new HashSet<String>();
	                sentinels.add("192.168.199.131:26379");
	                sentinels.add("192.168.199.131:26380");
	                sentinels.add("192.168.199.131:26381");
					jedisSentinelPool = new JedisSentinelPool(masterName, sentinels,"123456");
				}
			}
		}
		return jedisSentinelPool;
	}
	@SuppressWarnings("unused")
	public static void release(JedisSentinelPool jedisPool){
		jedisPool.close();
	}

}
