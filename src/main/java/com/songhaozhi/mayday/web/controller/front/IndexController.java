package com.songhaozhi.mayday.web.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.dto.ArchiveBo;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.web.controller.admin.BaseController;

/**
 * @author 宋浩志
 * @createDate 创建时间：2018年12月2日 下午5:12:40
 * 
 */
@RequestMapping(value = { "/", "index" })
@Controller
public class IndexController extends BaseController {
	@Autowired
	private ArticleService articleService;
	/**
	 * 请求首页
	 *
	 * @param model
	 *            model
	 * @param i
	 * @return 模板路径
	 */
	@GetMapping
	public String index(Model model) {
		// 调用方法渲染首页
		return this.index(model, 1);
	}

	/**
	 * 首页分页
	 *
	 * @return 模板路径/themes/{theme}/index
	 */
	@GetMapping(value = "page/{page}")
	public String index(Model model, @PathVariable(value = "page") Integer page) {
		page=page<0 || page>MaydayConst.MAX_PAGE ? 1 : page;
		//默认显示条数
		Integer limit=12;
		PageInfo<ArticleCustom> pageInfo=articleService.findPageArticle(page, limit, 0);
		model.addAttribute("articles", pageInfo);
		return this.render("index");
	}
	
	/**
	 * 归档 BY LHY
	 * @param model
	 * @return 
	 * @throws Exception 
	 */
	@GetMapping(value="placeOnFile")
	public String placeOnFile(Model model) throws Exception{
		List<ArchiveBo> archiveBos=articleService.placeOnFile();
		model.addAttribute("articleList", archiveBos);
		return this.render("archives");
	}
}
