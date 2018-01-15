package com.mobws.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mobws.system.entity.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain fc) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)srequest;
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("USER");
		if(user!=null){
			fc.doFilter(srequest, sresponse);
		}else{
			String request_uri = request.getRequestURI();
			// 得到web应用程序的上下文路径
		    String ctxPath = request.getContextPath();
		    // 去除上下文路径，得到剩余部分的路径
		    String uri = request_uri.substring(ctxPath.length());
			if(uri.contains("login")){
				fc.doFilter(srequest, sresponse);
			}else{
				sresponse.setContentType("text/html; charset=UTF-8");
				StringBuffer result = new StringBuffer();
				result.append("<script type='text/javascript'>");
				result.append("top.window.location='" + request.getContextPath() + "/system/login/login.jsp';");
				result.append("</script>");
				PrintWriter writer = sresponse.getWriter();
				writer.write(result.toString());
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
