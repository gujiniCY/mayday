package com.songhaozhi.mayday.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author : 宋浩志
* @createDate : 2019年1月3日
*/
@Controller
@RequestMapping("/admin/theme")
public class ThemeController extends BaseController{
	@GetMapping
	public String theme() {
		return "/admin/admin_theme";
	}

}
