package com.songhaozhi.mayday.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.model.domain.Log;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.LogConstant;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.ArticleStatus;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.service.CategoryService;
import com.songhaozhi.mayday.service.TagService;
import com.songhaozhi.mayday.util.MaydayUtil;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HtmlUtil;

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
	 * 
	 * @param model
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping
	public String article(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "status", defaultValue = "0") int status) {
		try {
			PageInfo<ArticleCustom> pageInfo = articleService.findPageArticle(page, limit, status);
			model.addAttribute("info", pageInfo);
			// 已发布条数
			model.addAttribute("published", articleService.countByStatus(0));
			// 草稿条数
			model.addAttribute("draft", articleService.countByStatus(1));
			// 回收站条数
			model.addAttribute("recycle", articleService.countByStatus(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/admin_article";
	}

	/**
	 * 过滤空格
	 * 
	 * @param articleTitle
	 * @return
	 */
	@PostMapping(value = "/filter")
	@ResponseBody
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
	@ResponseBody
	public JsonResult save(Article article, Long[] tags, Long[] categorys, HttpServletRequest request) {
		try {
			if (StrUtil.isEmpty(article.getArticleTitle())) {
				return new JsonResult(false, "文章标题不能为空");
			}
			//判断文章链接是否重复
			if(!StrUtil.isEmpty(article.getArticleUrl())) {
				//查询url是否重复
				int repeat=articleService.findRepeatByUrl(article.getArticleUrl());
				if(repeat !=0 ) {
					return new JsonResult(false, "文章路径已存在");
				}
			}
			if(article.getId()==null) {
				User user = (User) request.getSession().getAttribute(MaydayConst.USER_SESSION_KEY);
				article.setUserId(user.getUserId());
				article.setArticleNewstime(DateUtil.date());
				article.setArticleUpdatetime(DateUtil.date());
				//如果自定义链接为空则按时间戳生成链接
				if(StrUtil.isEmpty(article.getArticleUrl())) {
					article.setArticleUrl(String.valueOf(System.currentTimeMillis()/1000));
				}
				//如果没有选择略缩图则随机一张图
				if(StrUtil.isEmpty(article.getArticleThumbnail())) {
					article.setArticleThumbnail("/static/img/rand/"+RandomUtil.randomInt(1, 19)+".jpg");
				}
				//如果摘要为空则取前五十字为摘要
				int post_summary=50;
				if(StrUtil.isNotEmpty(MaydayConst.options.get("post_summary"))) {
					post_summary=Integer.parseInt(MaydayConst.options.get("post_summary"));
				}
				//清理html标签和空白字符
				String summaryText=StrUtil.cleanBlank(HtmlUtil.cleanHtmlTag(article.getArticleContent()));
				//设置文章摘要
				if(summaryText.length()>post_summary) {
					article.setArticleSummary(summaryText.substring(0, post_summary));
				}else {
					article.setArticleSummary(summaryText);
				}
				articleService.save(article, tags, categorys);
				//添加日志
				logService.save(new Log(LogConstant.PUBLISH_AN_ARTICLE, LogConstant.SUCCESS, ServletUtil.getClientIP(request),
						DateUtil.date()));
			}else {
				//如果没有选择略缩图则随机一张图
				if(StrUtil.isEmpty(article.getArticleThumbnail())) {
					article.setArticleThumbnail("/static/img/rand/"+RandomUtil.randomInt(1, 19)+".jpg");
				}
				//如果摘要为空则取前五十字为摘要
				int post_summary=50;
				if(StrUtil.isNotEmpty(MaydayConst.options.get("post_summary"))) {
					post_summary=Integer.parseInt(MaydayConst.options.get("post_summary"));
				}
				//清理html标签和空白字符
				String summaryText=StrUtil.cleanBlank(HtmlUtil.cleanHtmlTag(article.getArticleContent()));
				//设置文章摘要
				if(summaryText.length()>post_summary) {
					article.setArticleSummary(summaryText.substring(0, post_summary));
				}else {
					article.setArticleSummary(summaryText);
				}
				//文章最后修改时间
				article.setArticleUpdatetime(DateUtil.date());
				articleService.update(article, tags, categorys);
				//添加日志
				logService.save(new Log(LogConstant.UPDATE_AN_ARTICLE, LogConstant.SUCCESS, ServletUtil.getClientIP(request),
						DateUtil.date()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("添加或更新文章失败"+e.getMessage());
			return new JsonResult(MaydayEnums.ERROR.isFlag(), MaydayEnums.ERROR.getMessage());
		}
		return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(), MaydayEnums.PRESERVE_SUCCESS.getMessage());
	}

	/**
	 * 推送百度
	 * 
	 * @param token
	 *            在搜索资源平台申请的推送用的准入密钥
	 * @return
	 */
	@PostMapping(value = "/pushBaidu")
	@ResponseBody
	public JsonResult pushBaidu(@RequestParam(value = "token") String token) {
		try {
			if (StrUtil.isEmpty(token)) {
				return new JsonResult(false, "请先填写token");
			}
			// 文章为已发布
			int status = 0;
			String blogUrl = MaydayConst.options.get("blog_url");
			List<ArticleCustom> articles = articleService.findAllArticle(status);
			StringBuffer urls = new StringBuffer();
			for (ArticleCustom article : articles) {
				urls.append(blogUrl).append("/archives/").append(article.getArticleUrl()).append("\n");
			}
			String result = MaydayUtil.baiduPost(blogUrl, token, urls.toString());
			if (StrUtil.isEmpty(result)) {
				return new JsonResult(false, "推送失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(true, "推送成功");
	}

	/**
	 * 还原文章为发布状态
	 * 
	 * @param id
	 *            文章id
	 * @return
	 */
	@PostMapping(value = "/restore")
	@ResponseBody
	public JsonResult restore(@RequestParam(value = "id") int id) {
		try {
			articleService.recycle(id, ArticleStatus.PUBLISH.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(MaydayEnums.OPERATION_SUCCESS.isFlag(), MaydayEnums.OPERATION_SUCCESS.getMessage());
	}

	/**
	 * 修改文章状态为回收站
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/recycle")
	public String updateStatus(@RequestParam(value = "id") int id) {
		try {
			articleService.recycle(id, ArticleStatus.RECYCLE.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/article?status=0";
	}

	/**
	 * 彻底删除文章
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/remove")
	public String remove(@RequestParam(value = "id") int id, HttpServletRequest request) {
		try {
			articleService.remove(id);
			//添加日志
			logService.save(new Log(LogConstant.REMOVE_AN_ARTICLE, LogConstant.SUCCESS, ServletUtil.getClientIP(request),
					DateUtil.date()));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除文章失败"+e.getMessage());
		}
		return "redirect:/admin/article?status=2";
	}

	/**
	 * 新建文章页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/new")
	public String newArticle(Model model) {
		try {
			List<Category> categorys = categoryService.findCategory();
			List<Tag> tags = tagService.findTags();
			model.addAttribute("categorys", categorys);
			model.addAttribute("tags", tags);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/admin_new_article";
	}

	/**
	 * 修改文章页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit")
	public String editArticle(Model model, @RequestParam(value = "article_id") Integer article_id) {
		try {
			// 获取所有分类
			List<Category> categorys = categoryService.findCategory();
			// 获取所有标签
			List<Tag> tags = tagService.findTags();
			// 获取文章信息
			ArticleCustom articleCustom = articleService.findByArticleId(article_id);
			model.addAttribute("categorys", categorys);
			model.addAttribute("tags", tags);
			model.addAttribute("articleCustom", articleCustom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/admin_edit_article";
	}

	/**
	 * 
	 * @param article_id
	 *            文章id
	 * @return 该篇文章关联的分类和标签
	 */
	@PostMapping(value = "/ids")
	@ResponseBody
	public Map<String, Object> ids(Integer article_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取文章信息
			ArticleCustom articleCustom = articleService.findByArticleId(article_id);
			if(articleCustom.getTags()!=null) {
				map.put("tagsIds", articleCustom.getTags().split(","));
			}
			if(articleCustom.getCategorys()!=null) {
				map.put("categorysIds", articleCustom.getCategorys().split(","));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
