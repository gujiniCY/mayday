package com.songhaozhi.mayday.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.service.CategoryService;
import com.songhaozhi.mayday.service.TagService;

import cn.hutool.core.date.DateUtil;

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
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagService;
	@GetMapping
	public String article(Article article , @RequestParam(value="page",defaultValue="1") int page,@RequestParam(value="limit",defaultValue="10") int limit, Model model) {
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
	/**
	 * 保存文章
	 * @param article 文章
	 * @param tags 标签
	 * @param categorys 分类
	 * @return
	 */
	@PostMapping(value="/new/save")
	@ResponseBody
	public JsonResult save(Article article,Long[] tags,Long[] categorys,HttpServletRequest request) {
		try {
			User user=(User) request.getAttribute(MaydayConst.USER_SESSION_KEY);
			article.setUserId(user.getUserId());
			article.setArticleNewstime(DateUtil.date());
			article.setArticleUpdatetime(DateUtil.date());
			articleService.save(article,tags,categorys);
		} catch (Exception e) {
			return new JsonResult(MaydayEnums.PRESERVE_ERROR.isFlag(),MaydayEnums.PRESERVE_ERROR.getMessage());
		}
		return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(),MaydayEnums.PRESERVE_SUCCESS.getMessage());
	}

}
