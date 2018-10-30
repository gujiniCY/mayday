package com.songhaozhi.mayday.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.service.CategoryService;
import com.songhaozhi.mayday.service.TagService;

/**
* @author 宋浩志
* @createDate 创建时间：2018年10月15日 下午9:40:36
* 
*/
@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController{
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagService;
	@GetMapping
	public String article() {
		return "/admin/admin_article";
	}
	/**
	 * 新建文章页面
	 * @param model
	 * @return
	 */
	@GetMapping(value="/new")
	public String newArticle(Model model) {
		List<Category> categorys = categoryService.findCategory();
		List<Tag> tags = tagService.findTags();
		model.addAttribute("categorys", categorys);
		model.addAttribute("tags", tags);
		return "/admin/admin_new_article";
	}
}
