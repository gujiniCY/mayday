package com.songhaozhi.mayday.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author 宋浩志
* @createDate 创建时间：2018年10月15日 下午9:40:36
* 
*/
@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController{
	
	@GetMapping
	public String article() {
		return "/admin/admin_article";
	}

}
