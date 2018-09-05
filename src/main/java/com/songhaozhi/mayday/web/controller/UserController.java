package com.songhaozhi.mayday.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年8月27日 上午11:15:50
*/
@RequestMapping("/admin")
@Controller
public class UserController {
	
	@RequestMapping("/login")
	public String login() {
		return "admin/admin_login";
	}
	

}
