package com.songhaozhi.mayday.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.service.MenuService;
import com.songhaozhi.mayday.util.Commons;

/**
 * 前台拦截器
* @author : 宋浩志
* @createDate : 2018年12月6日
*/
@Component
public class IndexInterceptor  implements HandlerInterceptor{
	@Autowired
	 private Commons commons;
	@Autowired
	private MenuService menuService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
				return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//工具类
		request.setAttribute("commons", commons);
		//设置项
		request.setAttribute("options", MaydayConst.options);
		//菜单
		request.setAttribute("menus", MaydayConst.menus);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
