package com.hhb.app.dao;


import com.hhb.app.entil.User;

public interface UserDao {
	/*
	 * 保存用户
	 */
	public void saveUser(String Id,Object object);
	/*
	 * 通过userId获取用户信息
	 */
	public Object read(String userId);
	
	/*
	 * 通过userId删除用户信息
	 */
	public void delete(String userId);

}
