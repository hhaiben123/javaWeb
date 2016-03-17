package com.hhb.app.Until;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class SingleJredisPool {

	
	private JedisPool jedisPool;

	SingleJredisPool() { 
		singleJedisPool(); 
	}
	private void singleJedisPool(){
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		RedisConfig rc = new RedisConfig();
		poolConfig.setMaxIdle(rc.getMaxIdle());
		poolConfig.setMaxTotal(rc.getMaxActive());
		poolConfig.setMaxWaitMillis(rc.getMaxWait());
		poolConfig.setTestOnBorrow(rc.isTestOnBorrow());
		
		this.jedisPool = new JedisPool(poolConfig, rc.getIp(), rc.getPort(), rc.getTimeout());
	}
	
	public JedisPool getJedisPool() {
		return jedisPool;
	}
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
	
}
