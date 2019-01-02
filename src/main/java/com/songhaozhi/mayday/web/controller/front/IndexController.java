package com.songhaozhi.mayday.web.controller.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.model.domain.Link;
import com.songhaozhi.mayday.model.dto.ArchiveBo;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.ArticleStatus;
import com.songhaozhi.mayday.model.enums.PostType;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.service.CategoryService;
import com.songhaozhi.mayday.service.LinksService;
import com.songhaozhi.mayday.web.controller.admin.BaseController;

/**
 * @author : 宋浩志
 * @createDate : 2018年12月2日
 * 
 */
@Controller
public class IndexController extends BaseController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private LinksService linksService;
	@Autowired
	private CategoryService categoryService;

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
		page = page < 0 || page > MaydayConst.MAX_PAGE ? 1 : page;
		// 默认显示条数
		Integer limit = 12;
		ArticleCustom articleCustom = new ArticleCustom();
		articleCustom.setArticleStatus(ArticleStatus.PUBLISH.getStatus());
		articleCustom.setArticlePost(PostType.POST_TYPE_POST.getValue());
		PageInfo<ArticleCustom> pageInfo = articleService.findPageArticle(page, limit, articleCustom);
		model.addAttribute("articles", pageInfo);
		return this.render("index");
	}

	/**
	 * 归档 BY LHY
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "archives")
	public String archives(Model model) throws Exception {
		List<ArchiveBo> archiveBos = articleService.archives();
		model.addAttribute("articleList", archiveBos);
		return this.render("archives");
	}

	/**
	 * 文章页
	 * 
	 * @param model
	 * @param articleUrl
	 *            文章url
	 * @return
	 */
	@GetMapping(value = { "post/{articleUrl}", "post/{articleUrl}.html" })
	public String post(Model model, @PathVariable(value = "articleUrl") String articleUrl) {
		ArticleCustom articleCustom = articleService.findByArticleUrl(articleUrl);
		if (articleCustom == null) {
			return this.render_404();
		}
		model.addAttribute("article", articleCustom);
		return this.render("post");
	}

	/**
	 * 友链
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "links")
	public String links(Model model) {
		List<Link> links = linksService.findLinks();
		model.addAttribute("links", links);
		return this.render("links");
	}

	/**
	 * 自建页面
	 * 
	 * @param pagename
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/{articleUrl}")
	public String page(@PathVariable String articleUrl, Model model) {
		ArticleCustom articleCustom = articleService.findByArticleUrl(articleUrl);
		if (articleCustom == null) {
			return this.render_404();
		}
		model.addAttribute("article", articleCustom);
		return this.render("page");
	}

	/**
	 * 分类页
	 *
	 * @return
	 */
	@GetMapping(value = "category/{cateUrl}")
	public String categories(Model model, @PathVariable String cateUrl) {
		return this.categories(model, cateUrl, 1);
	}

	@GetMapping(value = "category/{cateUrl}/{page}")
	public String categories(Model model, @PathVariable String cateUrl, @PathVariable Integer page) {
		// 验证是否存在该路径
		Category category = categoryService.findByCateUrl(cateUrl);
		if (category == null) {
			this.render_404();
		}
		Integer size = 12;
		page = page < 0 || page > MaydayConst.MAX_PAGE ? 1 : page;
		PageInfo<ArticleCustom> info = articleService.findArtileByCategory(page, size, category);
		model.addAttribute("articles", info);
		model.addAttribute("type", "分类");
		model.addAttribute("cateUrl", cateUrl);
		return this.render("page-category");
	}
}
