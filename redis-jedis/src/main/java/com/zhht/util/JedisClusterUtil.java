package com.zhht.util;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 
* @ClassName: JedisClusterUtil  
* <p>Description: jedisCluster测试使用   </p>
* @author  frankman
* @date 2020年3月12日 下午9:21:52  
*
 */
public class JedisClusterUtil {
	public static void main(String[] args) {
		JedisCluster cluster = null; 
		try {
		Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.199.131", 8000));
        nodes.add(new HostAndPort("192.168.199.131", 8001));
        nodes.add(new HostAndPort("192.168.199.131", 8002));
        nodes.add(new HostAndPort("192.168.199.131", 8003));
        nodes.add(new HostAndPort("192.168.199.131", 8004));
        nodes.add(new HostAndPort("192.168.199.131", 8006));
        cluster = new JedisCluster(nodes,8000,8000,3,"123456",new JedisPoolConfig());
        String res = cluster.get("name");
        System.out.println(res);    
        cluster.close();
        } catch (Exception e) {
            e.printStackTrace();
            cluster.close();
        }
	}

}
