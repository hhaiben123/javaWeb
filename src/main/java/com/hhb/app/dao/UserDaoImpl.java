package com.hhb.app.dao;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.hhb.app.entil.User;

@Component
public class UserDaoImpl implements UserDao{
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public void saveUser(String Id,Object object) {
		ValueOperations<String, Object> valueOper = redisTemplate.opsForValue();
		valueOper.set(Id, object,30,TimeUnit.MINUTES);
	}
	
	
	  public Object read(String Id) {  
	        ValueOperations<String, Object> valueOper = redisTemplate.opsForValue();  
	        return valueOper.get(Id);  
	    } 
	  
	   public void delete(String Id) {  
	        ValueOperations<String, Object> valueOper = redisTemplate.opsForValue();  
	        RedisOperations<String,Object>  RedisOperations  = valueOper.getOperations();  
	        RedisOperations.delete(Id);  
	    }
}
