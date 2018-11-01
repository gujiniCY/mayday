package com.songhaozhi.mayday.web.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.dto.PageJson;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.model.enums.PostType;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.util.MaydayUtil;
import com.songhaozhi.mayday.web.controller.admin.BaseController;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年10月30日 下午2:33:40
 */
@RestController
@RequestMapping(value = "/api/admin/article")
public class ApiArticleController extends BaseController {
	@Autowired
	private ArticleService articleService;
	@GetMapping(value="/page")
	public PageInfo<ArticleCustom> article(ArticleCustom articleCustom , @RequestParam(value="offset") int page,@RequestParam(value="limit") int limit, Model model) {
		PageInfo<ArticleCustom> pageInfo=articleService.findPageArticle(articleCustom,page, limit);
		return pageInfo;
	}
	/**
	 * 过滤空格
	 * 
	 * @param articleTitle
	 * @return
	 */
	@PostMapping(value = "/filter")
	public JsonResult filter(String articleTitle) {
		articleTitle = articleTitle.replaceAll(" ", "-");
		return new JsonResult(true, articleTitle);
	}
	/**
	 * 保存文章
	 * 
	 * @param article
	 *            文章
	 * @param tags
	 *            标签
	 * @param categorys
	 *            分类
	 * @return
	 */
	@PostMapping(value = "/new/save")
	public JsonResult save(Article article, Long[] tags, Long[] categorys, HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute(MaydayConst.USER_SESSION_KEY);
			article.setUserId(user.getUserId());
			article.setArticleNewstime(DateUtil.date());
			article.setArticleUpdatetime(DateUtil.date());
			articleService.save(article, tags, categorys);
		} catch (Exception e) {
			return new JsonResult(MaydayEnums.PRESERVE_ERROR.isFlag(), MaydayEnums.PRESERVE_ERROR.getMessage());
		}
		return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(), MaydayEnums.PRESERVE_SUCCESS.getMessage());
	}

	/**
	 * 推送百度
	 * 
	 * @param token
	 * 			在搜索资源平台申请的推送用的准入密钥
	 * @return
	 */
	@PostMapping(value = "/pushBaidu")
	public JsonResult pushBaidu(@RequestParam(value = "token") String token) {
		if(StrUtil.isEmpty(token)) {
			return new JsonResult(false,"请先填写token");
		}
		String blog_url=MaydayConst.options.get("blog_url");
		List<Article> articles=articleService.findAllArticle(PostType.POST_TYPE_POST.getValue());
		StringBuffer urls=new StringBuffer();
		for (Article article : articles) {
			urls.append(blog_url).append("/archives/").append(article.getArticleUrl()).append("\n");
		}
		String result=MaydayUtil.baiduPost(blog_url, token, urls.toString());
		if(StrUtil.isEmpty(result)) {
			return new JsonResult(false,"推送失败");
		}
		return new JsonResult(true,"推送成功");
	}
}
