package com.mobws.system.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class BaseController {

	public void writetoPage(HttpServletResponse response,String s){
		try{
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			out.print(s);
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
