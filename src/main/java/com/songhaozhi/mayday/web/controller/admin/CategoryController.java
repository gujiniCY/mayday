package com.songhaozhi.mayday.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.service.CategoryService;

/**
 * @author 宋浩志
 * @createDate 创建时间：2018年9月26日 下午8:43:00
 * 
 */
@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController extends BaseController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String category(Model model) {
		List<Category> Categorys = categoryService.findCategory();
		model.addAttribute("Categorys", Categorys);
		return "/admin/admin_category";
	}

}
