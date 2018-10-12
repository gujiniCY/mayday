package com.songhaozhi.mayday.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年10月12日 上午10:08:40
*/
@RequestMapping("/admin/option")
@Controller
public class OptionsController extends BaseController{
	@GetMapping
	public String option() {
		return "/admin/admin_options";
	}

}
