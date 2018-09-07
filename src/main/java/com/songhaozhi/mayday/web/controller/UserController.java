package com.songhaozhi.mayday.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年9月7日 上午9:17:05
 */
@RequestMapping("/admin/datum")
@Controller
public class UserController extends BaseController {
	@GetMapping
	public String datum() {
		return "/admin/admin_user";
	}
}
