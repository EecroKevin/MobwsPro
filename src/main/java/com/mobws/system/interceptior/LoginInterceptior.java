package com.mobws.system.interceptior;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mobws.system.entity.User;

public class LoginInterceptior implements HandlerInterceptor {

	@Override
	//视图被显示之后所执行的方法
	//主要用于资源销毁等
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//System.out.println("执行到了 Test2Interceptior（HandlerInterceptor）afterCompletion 方法");
	}

	@Override
	//ModelAndView arg3 改变显示的视图，或修改发往视图的方法
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		//System.out.println("执行到了 Test2Interceptior（HandlerInterceptor）postHandle 方法");
	}

	@Override
	//是否需要将当前的请求拦截下来
	// false 请求将被终止
	// true 请求继续运行
	//Object arg2 表示被拦截的请求的目标对象
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		//System.out.println("执行到了 Test2Interceptior（HandlerInterceptor）preHandle 方法");
		//对用户是否登录进行验证
		if(arg0.getSession().getAttribute("user")==null){
			arg0.getRequestDispatcher("/login.do").forward(arg0, arg1);
			return false;
		}
		return true;
	}

}
