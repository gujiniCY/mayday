package com.songhaozhi.mayday.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.songhaozhi.mayday.web.interceptor.LoginInterceptor;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年9月10日 上午9:14:01
*/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
    @Autowired
    private LoginInterceptor  loginAuthenticator;
    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	 registry.addInterceptor(loginAuthenticator)
         .addPathPatterns("/admin/**")
         .excludePathPatterns("/admin/login")
         .excludePathPatterns("/admin/getLogin")
         .excludePathPatterns("/static/**");
    }
}
