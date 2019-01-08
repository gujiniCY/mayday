package com.songhaozhi.mayday.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.songhaozhi.mayday.model.dto.MaydayConst;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月5日
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object obj = request.getSession().getAttribute(MaydayConst.USER_SESSION_KEY);
		// 如果user不为空则放行
		if (null != obj) {
			return true;
		}
		// 否则拦截并跳转到登录
		response.sendRedirect("/admin/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
