package com.zhht.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
* @ClassName: JedisClusterFactory  
* <p>Description: jedis集群模式 工厂类   </p>
* @author  frankman
* @date 2020年3月11日 下午4:46:45  
*
 */
public class JedisClusterFactory {
	
	private Logger logger = LoggerFactory.getLogger(JedisClusterFactory.class);
	
	private String password;
	//超时时间 毫秒单位
	private int timeOut;
	private List<String> hostPortList;
	private JedisCluster cluster ;
	
	public void init(){
		Set<HostAndPort> nodes = new HashSet<>();
		for(String hostAndPort : hostPortList){
			String arr[] = hostAndPort.split(":");
			if(arr.length!=2){
				continue;
			}
			nodes.add(new HostAndPort(arr[0],Integer.parseInt(arr[1])));
		}
		try {
        cluster = new JedisCluster(nodes,timeOut,timeOut,10,password,new JedisPoolConfig());
        } catch (Exception e) {
            cluster.close();
            logger.error(e.getMessage(),e);
        }
	}
	public void destory() {
		try {
			if(cluster != null){
				cluster.close();
			}
		} catch (Exception e) {
			 logger.error(e.getMessage(),e);
		}
	}
	

}
