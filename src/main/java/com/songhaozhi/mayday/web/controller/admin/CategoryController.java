package com.songhaozhi.mayday.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.service.CategoryService;

/**
 * @author 宋浩志
 * @createDate 创建时间：2018年9月26日 下午8:43:00
 * 分类
 */
@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController extends BaseController {
	@Autowired
	private CategoryService categoryService;
	/**
	 * 分类页面
	 * @param model
	 * @return
	 */
	@GetMapping
	public String category(Model model) {
		List<Category> Categorys = categoryService.findCategory();
		model.addAttribute("Categorys", Categorys);
		return "/admin/admin_category";
	}
	/**
	 * 跳转修改页面
	 * @param model
	 * @param categoryId
	 * @return
	 */
	@GetMapping(value="/edit")
	public String updateCategory(Model model,@RequestParam(value="categoryId") int categoryId) {
		Category category = categoryService.findByCategoryId(categoryId);
		List<Category> Categorys = categoryService.findCategory();
		model.addAttribute("Categorys", Categorys);
		model.addAttribute("category", category);
		return "/admin/admin_category";
	}
	/**
	 * 添加或修改
	 * @param category
	 * @return
	 */
	@PostMapping(value="/save")
	public String save(Category category) {
	try {
		if(category.getCategoryId()==null) {
			categoryService.save(category);
		}else {
			categoryService.update(category);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "redirect:/admin/category";
	}
	/**
	 * 删除
	 * @param categoryId
	 * @return
	 */
	@GetMapping(value="/remove")
	public String remove(@RequestParam(value="categoryId") int categoryId) {
		try {
		categoryService.delete(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/category";
	}

}
