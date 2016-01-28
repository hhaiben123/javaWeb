package com.hhb.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.hhb.app.entil.User;

@Component
public class UserDaoImpl implements UserDao{
	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	
	public void saveUser(User user) {
		ValueOperations<String, User> valueOper = redisTemplate.opsForValue();
		valueOper.set(user.getUserId(), user);
	}
	
	
	  public User read(String userId) {  
	        ValueOperations<String, User> valueOper = redisTemplate.opsForValue();  
	        return valueOper.get(userId);  
	    } 
	  
	   public void delete(String userId) {  
	        ValueOperations<String, User> valueOper = redisTemplate.opsForValue();  
	        RedisOperations<String,User>  RedisOperations  = valueOper.getOperations();  
	        RedisOperations.delete(userId);  
	    }
}
