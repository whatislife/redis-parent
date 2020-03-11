package com.zhht.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterJunit {
	
	@Test
    public void testCluster() throws IOException, InterruptedException {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.199.131", 8000));
        nodes.add(new HostAndPort("192.168.199.131", 8001));
        nodes.add(new HostAndPort("192.168.199.131", 8002));
        JedisCluster cluster = new JedisCluster(nodes);
        try {
            String res = cluster.get("name");
            System.out.println(res);    
            cluster.close();
        } catch (Exception e) {
            e.printStackTrace();
            cluster.close();
        }
    }

}
