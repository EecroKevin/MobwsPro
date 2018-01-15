package com.mobws.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mobws.system.dao.UserDao;
import com.mobws.system.entity.User;
import com.mobws.system.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public User login(String loginname, String password) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("loginname", loginname);
		map.put("password", password);
		return userDao.login(map);
	}


	@Override
	public List<User> getUserList(Map<String, String> map) {
		List<User> userList = userDao.getUserList(map);
		return userList;
	}


	@Override
	public int totalPage(Map<String, String> map) {
		int i = userDao.totalPage(map);
		return i;
	}

}
