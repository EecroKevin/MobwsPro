package com.mobws.system.dao;

import java.util.List;
import java.util.Map;

import com.mobws.system.entity.User;

public interface UserDao {

	/**
	 * 用户登录
	 * @param map
	 * @return
	 */
	public User login(Map<String, String> map);
	
	/**
	 * 查询对应部门下的用户
	 * @param map
	 * @return
	 */
	public List<User> getUserList(Map<String, String> map);
	
	public int totalPage(Map<String, String> map);
}
