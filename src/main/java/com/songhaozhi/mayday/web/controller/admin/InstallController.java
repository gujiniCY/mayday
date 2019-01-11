package com.songhaozhi.mayday.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author : 宋浩志
* @createDate : 2019年1月11日
*/
@Controller
@RequestMapping(value="/install")
public class InstallController {
	@GetMapping
	public String install() {
		return "/install";
	}

}
