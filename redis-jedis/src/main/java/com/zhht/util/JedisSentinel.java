package com.zhht.util;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;
/**
 * 
* @ClassName: JedisSentinel  
* <p>Description: 哨兵测试   </p>
* @author  frankman
* @date 2020年3月10日 下午9:39:19  
*
 */
public class JedisSentinel {

    public static void main(String[] args) {
    	Jedis jedis = null;
    	 try {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMaxWaitMillis(1000);

        String masterName = "mymaster";
        Set<String> sentinelSet = new HashSet<>();
        sentinelSet.add("192.168.199.131:26379");
        sentinelSet.add("192.168.199.131:26380");
        sentinelSet.add("192.168.199.131:26381");
        JedisSentinelPool pool = new JedisSentinelPool(masterName, sentinelSet,"123456");
            jedis = pool.getResource();
            String value = jedis.get("hello");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

}
