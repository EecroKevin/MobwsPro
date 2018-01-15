package com.mobws.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mobws.system.entity.User;
import com.mobws.system.service.UserService;

@Controller
public class UserController extends BaseController{

	@Resource(name="userServiceImpl")
	private UserService userSerrvice;
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/login.do")
	public void login(HttpServletRequest request, HttpServletResponse response){
		
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		
		User user = userSerrvice.login(loginname, password);

		if(user != null){
			request.getSession().setAttribute("USER", user);
			writetoPage(response, "loginok");
		}else{
			writetoPage(response, "error");
		}
	}
	
	@RequestMapping(value="/getUserList.do")
	public void getUserList(HttpServletRequest request, HttpServletResponse response){
		int pn = 0;
		String pagesize = request.getParameter("pagesize");
		String pagenum = request.getParameter("pagenum");
		//计算页码
		pn=Integer.parseInt(pagesize)*Integer.parseInt(pagenum);
		
		String departmentId = request.getParameter("departmentId");
		String query = request.getParameter("query");
		Map<String, String> map = new HashMap<String, String>();
		map.put("pagesize", pn + "");
		map.put("pagenum", pagenum);
		map.put("departmentId", departmentId);
		map.put("query", query);
		//获取数据
		List<User> list = userSerrvice.getUserList(map);
		int total = userSerrvice.totalPage(map);
		//转换为JSon
		JSONArray json = new JSONArray();
		json.put(list);
		//.fromObject(list);
		
		String str = "{total:"+total+",data:["+json.toString()+"]}";
		writetoPage(response, str);
	}
	
	
}
