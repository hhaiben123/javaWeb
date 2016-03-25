package com.hhb.app.Until;

import java.util.ResourceBundle;

public class RedisConfig {
	//Redis服务器IP
    private  String ip;
     
    //Redis的端口号
    private  int port;
    
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private  int maxActive;
     
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private  int maxIdle;
     
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private  int maxWait;
 
    //超时时间
    private  int timeout;
    
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private  boolean testOnBorrow;
    
    //构造函数
    public RedisConfig (){
    	ResourceBundle rb = ResourceBundle.getBundle("redis");
    	
    	String ips = rb.getString("redis.host");
    	if (ips!=null) {
			this.ip = ips;
		}else {
			this.ip = null;
		}
    	
    	String ports = rb.getString("redis.port");
    	if (ports!=null) {
			this.port = Integer.valueOf(ports);
		}else {
			this.port = 0;
		}
    	
    	String maxActives = rb.getString("redis.maxActive");
    	if (maxActives!=null) {
			this.maxActive = Integer.valueOf(maxActives);
		}else {
			this.maxActive = 0;
		}
    	
    	String maxIdles = rb.getString("redis.maxIdle");
    	if (maxIdles!=null) {
			this.maxIdle = Integer.valueOf(maxIdles);
		}else {
			this.maxIdle = 0;
		}
    	
    	String maxWaits = rb.getString("redis.maxWait");
    	if (maxWaits!=null) {
			this.maxWait = Integer.valueOf(maxWaits);
		}else {
			this.maxWait = 0;
		}
    	
    	String timeouts = rb.getString("redis.timeout");
    	if (timeouts!=null) {
			this.timeout = Integer.valueOf(timeouts);
		}else {
			this.timeout = 0;
		}
    	String testOnBorrows = rb.getString("redis.testOnBorrow");
    	if (testOnBorrows.endsWith("true")) {
			this.testOnBorrow = true;
		}else {
			this.testOnBorrow = false;
		}
    }

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	
    
    
}
