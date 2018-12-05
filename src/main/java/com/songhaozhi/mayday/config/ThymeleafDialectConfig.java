package com.songhaozhi.mayday.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.songhaozhi.mayday.config.thymeleaf.dialect.ThSysDialect;

/**
 * Thymeleaf配置
* @author 宋浩志
* @createDate 创建时间：2018年12月4日 下午9:29:53
* 
*/
@Configuration
public class ThymeleafDialectConfig {
	@Bean
	public ThSysDialect thSysDialect() {
		return new ThSysDialect();
	}
}
