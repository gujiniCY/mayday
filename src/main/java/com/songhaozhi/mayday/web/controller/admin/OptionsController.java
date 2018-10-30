package com.songhaozhi.mayday.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年10月12日 上午10:08:40
 */

@Controller
@RequestMapping("/admin/option")
public class OptionsController extends BaseController {
	/**
	 * 所有设置选项
	 * @param model
	 * @return
	 */
	@GetMapping
	public String option(Model model) {
		return "/admin/admin_options";
	}
}
