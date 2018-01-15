package com.mobws.system.service;

import java.util.List;
import java.util.Map;

import com.mobws.system.entity.User;

public interface UserService {

	/**
	 * 用户登录
	 * @param loginname
	 * @param password
	 * @return
	 */
	public User login(String loginname, String password);
	
	/**
	 * 查询对应部门下的用户
	 * @param map
	 * @return
	 */
	public List<User> getUserList(Map<String, String> map);
	
	public int totalPage(Map<String, String> map);
}
