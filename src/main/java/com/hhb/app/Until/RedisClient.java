package com.hhb.app.Until;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisClient {
	protected static Logger logger = Logger.getLogger(RedisClient.class);
	
	static SingleJredisPool singleJredisPool = new SingleJredisPool();
	static JedisPool jedisPool = singleJredisPool.getJedisPool();

 
 
    /**
     * 同步获取Jedis实例
     * @return Jedis
     */
    public synchronized static Jedis getJedis() {  
        Jedis jedis = null;
        try {  
            if (jedisPool != null) {  
                jedis = jedisPool.getResource(); 
            }
        } catch (Exception e) {  
            logger.error("Get jedis error : "+e);
        }finally{
            returnResource(jedis);
        }
        return jedis;
    }  
    
    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null && jedisPool !=null) {
            jedisPool.returnResource(jedis);
        }
    }
	
    /**
     * 设置 String
     * @param key
     * @param value
     */
    public static void setString(String key ,Object object){
        try {
        	String value = JSON.toJSONString(object);
            getJedis().set(key,value);
        } catch (Exception e) {
            logger.error("Set key error : "+e);
        }
    }
     
    /**
     * 设置 过期时间
     * @param key
     * @param seconds 以秒为单位
     * @param value
     */
    public static void setString(String key ,Object object, int seconds){
        try {
        	String value = JSON.toJSONString(object);
            getJedis().setex(key, seconds, value);
        } catch (Exception e) {
            logger.error("Set keyex error : "+e);
        }
    }
     
    /**
     * 获取String值
     * @param key
     * @return value
     */
    public static String getString(String key){
        if(getJedis() == null || !getJedis().exists(key)){
            return null;
        }
        return getJedis().get(key);
    }
    
    /**
     * 删除Key值
     * @param key
     * @return 
     * @return value
     */
    public static Long detString(String key){
        if(getJedis() == null || !getJedis().exists(key)){
            return null;
        }
        return getJedis().del(key);
    }
}
