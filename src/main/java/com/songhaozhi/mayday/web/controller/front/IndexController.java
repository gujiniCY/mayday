package com.songhaozhi.mayday.web.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
@Controller
public class IndexController extends BaseController {
	@Autowired
	private ArticleService articleService;
	/**
	 * 请求首页
	 *
	 * @param model
	 * @return 模板路径
	 */
	@GetMapping(value = { "/", "index" })
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
		try {
			page=page<0 || page>MaydayConst.MAX_PAGE ? 1 : page;
			//默认显示条数
			Integer limit=12;
			PageInfo<ArticleCustom> pageInfo=articleService.findPageArticle(page, limit, 0);
			model.addAttribute("articles", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.render("index");
	}
	
	/**
	 * 归档 BY LHY
	 * @param model
	 * @return 
	 * @throws Exception 
	 */
	@GetMapping(value="archives")
	public String archives(Model model) throws Exception{
		List<ArchiveBo> archiveBos=articleService.archives();
		model.addAttribute("articleList", archiveBos);
		return this.render("archives");
	}
}
