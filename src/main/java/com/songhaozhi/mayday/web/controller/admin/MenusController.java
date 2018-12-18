package com.songhaozhi.mayday.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.songhaozhi.mayday.model.domain.Menu;
import com.songhaozhi.mayday.service.MenuService;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年12月18日 下午4:10:28
*/
@RequestMapping("/admin/menus")
@Controller
public class MenusController extends BaseController{
	@Autowired
	private MenuService menuService;
	@GetMapping
	public String menus(Model model) {
		List<Menu> menus=menuService.findMenus();
		model.addAttribute("menus", menus);
		return "/admin/admin_menus";
	}

}
