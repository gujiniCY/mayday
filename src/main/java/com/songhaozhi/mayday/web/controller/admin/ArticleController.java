package com.songhaozhi.mayday.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.service.ArticleService;

/**
* @author 宋浩志
* @createDate 创建时间：2018年10月15日 下午9:40:36
* 
*/
@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController{
	@Autowired
	private ArticleService articleService;
	@GetMapping
	public String article(Article article , @RequestParam(value="page",defaultValue="1") int page,@RequestParam(value="limit",defaultValue="10") int limit, Model model) {
		return "/admin/admin_article";
	}
	@GetMapping(value="/new")
	public String newArticle() {
		return "/admin/admin_new_article";
	}

}
