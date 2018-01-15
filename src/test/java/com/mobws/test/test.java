package com.mobws.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mobws.system.entity.Department;
import com.mobws.system.entity.User;
import com.mobws.system.service.DepartmentService;
import com.mobws.system.service.UserService;

public class test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/mobws/system/config/applicationContext.xml");
//		UserService userService = (UserService)ac.getBean("userServiceImpl");
//		User user = userService.login("admin", "admin");
//		System.out.println(user.toString());
		DepartmentService departmentService = (DepartmentService)ac.getBean("departmentServiceImpl");
		List<Department> departmentList = departmentService.queryAllDepartments();
		System.out.println(departmentList.toString());
	}
	
}
