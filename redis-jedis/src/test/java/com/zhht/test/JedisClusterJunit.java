package com.zhht.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 
* @ClassName: JedisClusterJunit  
* <p>Description: jedis集群模式使用   </p>
* @author  frankman
* @date 2020年3月11日 下午3:43:39  
*
 */
public class JedisClusterJunit {
	
	@Test
    public void testCluster()  {
		JedisCluster cluster = null; 
		try {
		Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.199.131", 8000));
        nodes.add(new HostAndPort("192.168.199.131", 8001));
        nodes.add(new HostAndPort("192.168.199.131", 8002));
        nodes.add(new HostAndPort("192.168.199.131", 8003));
        nodes.add(new HostAndPort("192.168.199.131", 8004));
        nodes.add(new HostAndPort("192.168.199.131", 8006));
        cluster = new JedisCluster(nodes,5000,3000,10,"123456",new JedisPoolConfig());
        String res = cluster.get("name");
        System.out.println(res);    
        cluster.close();
        } catch (Exception e) {
            e.printStackTrace();
            cluster.close();
        }
    }

}
