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
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.ArticleStatus;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.service.CategoryService;
import com.songhaozhi.mayday.service.TagService;
import com.songhaozhi.mayday.util.MaydayUtil;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

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
			if(StrUtil.isEmpty(article.getArticleTitle())) {
				return new JsonResult(false, "文章标题不能为空");
			}
			if(StrUtil.isEmpty(article.getArticleUrl())) {
				return new JsonResult(false, "文章链接不能为空");
			}
			User user = (User) request.getSession().getAttribute(MaydayConst.USER_SESSION_KEY);
			article.setUserId(user.getUserId());
			article.setArticleNewstime(DateUtil.date());
			article.setArticleUpdatetime(DateUtil.date());
			articleService.save(article, tags, categorys);
		} catch (Exception e) {
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
	 * @param id
	 * @return
	 */
	@GetMapping(value="/recycle")
	public String updateStatus(@RequestParam(value="id") int id) {
		try {
			articleService.recycle(id,ArticleStatus.RECYCLE.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/article";
	}
	/**
	 * 彻底删除文章
	 * @param id
	 * @return
	 */
	@GetMapping(value="/remove")
	public String remove(@RequestParam(value="id") int id) {
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
	/**
	 * 修改文章页面
	 * @param model
	 * @return
	 */
	@GetMapping(value="/edit")
	public String editArticle(Model model,@RequestParam(value="article_id")Integer article_id) {
		//获取所有分类
		List<Category> categorys = categoryService.findCategory();
		//获取所有标签
		List<Tag> tags = tagService.findTags();
		//获取文章信息
		ArticleCustom articleCustom=articleService.findByArticleId(article_id);
		model.addAttribute("categorys", categorys);
		model.addAttribute("tags", tags);
		model.addAttribute("articleCustom", articleCustom);
		return "/admin/admin_edit_article";
	}
	/**
	 * 
	 * @param article_id 文章id
	 * @return 该篇文章关联的分类和标签
	 */
	@PostMapping(value="/ids") 
	@ResponseBody
	public Map<String, Object> ids(Integer article_id) {
		Map<String, Object> map=new HashMap<String, Object>();
		//获取文章信息
		ArticleCustom articleCustom=articleService.findByArticleId(article_id);
		String[] tags=articleCustom.getTags().split(",");
		String[] categorys = articleCustom.getCategorys().split(",");
		map.put("tagsIds", tags);
		map.put("categorysIds", categorys);
		return map;
	}
	
	
}
