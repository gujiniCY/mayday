package com.songhaozhi.mayday.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.service.CategoryService;
import com.songhaozhi.mayday.service.TagService;

/**
 * @author 宋浩志
 * @createDate 创建时间：2018年10月15日 下午9:40:36
 * 
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagService;
	@Autowired
	private ArticleService articleService;
	/**
	 * 显示所有文章
	 * @param model
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping
	public String article(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,@RequestParam(value="status",defaultValue="0") int status) {
		PageInfo<ArticleCustom> pageInfo = articleService.findPageArticle(page, limit,status);
		//已发布条数
		Integer published=articleService.countByStatus(0);
		//草稿条数
		Integer draft=articleService.countByStatus(1);
		//回收站条数
		Integer recycle=articleService.countByStatus(2); 
		model.addAttribute("info", pageInfo);
		model.addAttribute("draft", draft);
		model.addAttribute("recycle", recycle);
		model.addAttribute("published", published);
		return "/admin/admin_article";
	}
	/**
	 * 修改文章状态为回收站
	 * @param id
	 * @return
	 */
	@GetMapping(value="/remove")
	public String updateStatus(@RequestParam(value="id") int id) {
		try {
			articleService.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/article";
	}

	/**
	 * 新建文章页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/new")
	public String newArticle(Model model) {
		List<Category> categorys = categoryService.findCategory();
		List<Tag> tags = tagService.findTags();
		model.addAttribute("categorys", categorys);
		model.addAttribute("tags", tags);
		return "/admin/admin_new_article";
	}
}
