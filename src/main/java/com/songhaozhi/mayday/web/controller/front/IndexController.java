package com.songhaozhi.mayday.web.controller.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.model.domain.Link;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.model.dto.ArchiveBo;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.ArticleStatus;
import com.songhaozhi.mayday.model.enums.PageNumber;
import com.songhaozhi.mayday.model.enums.PostType;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.service.CategoryService;
import com.songhaozhi.mayday.service.LinksService;
import com.songhaozhi.mayday.service.TagService;
import com.songhaozhi.mayday.web.controller.admin.BaseController;

import cn.hutool.extra.servlet.ServletUtil;

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
	@Autowired
	private TagService tagService;

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
		Integer limit = MaydayConst.OPTIONS.get("index_article") == null ? PageNumber.POST_INDEX_lIMIT.getLimit()
				: Integer.parseInt(MaydayConst.OPTIONS.get("index_article"));
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
	public String post(Model model, @PathVariable(value = "articleUrl") String articleUrl,HttpServletRequest request) {
		ArticleCustom articleCustom = articleService.findByArticleUrl(articleUrl);
		if (articleCustom == null) {
			return this.render_404();
		}
		if(!checkRepeatIp(request, articleCustom.getId())) {
			updateArticleViews(articleCustom.getId(),articleCustom.getArticleViews());
		}
		model.addAttribute("article", articleCustom);
		return this.render("post");
	}
	/**
	 * 检测同一IP十分钟以内重复访问同一篇文章
	 * @param request
	 * @param id 文章id
	 * @return
	 */
	public boolean checkRepeatIp(HttpServletRequest request,int id) {
		
		String value=ServletUtil.getClientIP(request)+":"+id;
		Integer count=cache.hget("hits:frequency", value);
		if(count!=null && count>0) {
			return true;
		}
		cache.hset("hits:frequency", value,1,MaydayConst.IP_REPEAT_TIME);
		return false;
	}
	/**
	 * 修改文章点击率
	 * @param id
	 * @param views
	 */
	public void updateArticleViews(Integer id,Long views) {
		if (views == null) {
			views = 0L;
        }
		//获取缓存数据
		Long cacheViews=cache.hget("article"+id, "cacheViews");
		//如果缓存数据为null赋值1，反之加1
		cacheViews=cacheViews == null ? 1 : cacheViews+1;
		//如果缓存只大于等于设置的次数则修改到数据库
		if(cacheViews>=MaydayConst.CLICK_EXCEED) {
			Article article=new Article();
			article.setId(id);
			article.setArticleViews(views+cacheViews);
			articleService.updateArticleViews(article);
			cache.hset("article"+id, "cacheViews", null);
		}else {
			cache.hset("article"+id, "cacheViews", cacheViews);
		}
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
	public String page(@PathVariable String articleUrl, Model model,HttpServletRequest request) {
		ArticleCustom articleCustom = articleService.findByArticleUrl(articleUrl);
		if (articleCustom == null) {
			return this.render_404();
		}
		if(!checkRepeatIp(request, articleCustom.getId())) {
			updateArticleViews(articleCustom.getId(),articleCustom.getArticleViews());
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
		Integer limit = PageNumber.POST_INDEX_lIMIT.getLimit();
		page = page < 0 || page > MaydayConst.MAX_PAGE ? 1 : page;
		PageInfo<ArticleCustom> info = articleService.findArtileByCategory(page, limit, category);
		model.addAttribute("articles", info);
		model.addAttribute("type", "分类");
		model.addAttribute("url", "category/" + category.getCategoryUrl());
		model.addAttribute("keywords", category.getCategoryName());
		return this.render("page-category");
	}

	/**
	 * 标签页
	 *
	 * @return
	 */
	@GetMapping(value = "tags/{tagUrl}")
	public String tags(Model model, @PathVariable String tagUrl) {
		return this.tags(model, tagUrl, 1);
	}

	@GetMapping(value = "tags/{tagUrl}/{page}")
	public String tags(Model model, @PathVariable String tagUrl, @PathVariable Integer page) {
		// 验证是否存在该路径
		Tag tag = tagService.findByTagUrl(tagUrl);
		if (tag == null) {
			this.render_404();
		}
		Integer limit = PageNumber.POST_INDEX_lIMIT.getLimit();
		page = page < 0 || page > MaydayConst.MAX_PAGE ? 1 : page;
		PageInfo<ArticleCustom> info = articleService.findArtileByTag(page, limit, tag);
		model.addAttribute("articles", info);
		model.addAttribute("type", "标签");
		model.addAttribute("url", "tags/" + tag.getTagUrl());
		model.addAttribute("keywords", tag.getTagName());
		return this.render("page-category");
	}

	/**
	 * 标题搜索
	 *
	 * @return
	 */
	@GetMapping(value = "search/{keywords}")
	public String search(Model model, @PathVariable String keywords) {
		return this.search(model, keywords, 1);
	}

	@GetMapping(value = "search/{keywords}/{page}")
	public String search(Model model, @PathVariable String keywords, @PathVariable Integer page) {
		Integer limit = PageNumber.POST_INDEX_lIMIT.getLimit();
		page = page < 0 || page > MaydayConst.MAX_PAGE ? 1 : page;
		PageInfo<Article> info = articleService.findArticleByKeywords(keywords, page, limit);
		model.addAttribute("articles", info);
		model.addAttribute("type", "搜索");
		model.addAttribute("keywords", keywords);
		model.addAttribute("url", "search/" + keywords);
		return this.render("page-category");
	}

}
