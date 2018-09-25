package com.songhaozhi.mayday.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.songhaozhi.mayday.model.domain.Link;
import com.songhaozhi.mayday.service.LinksService;

/**
* @author 宋浩志
* @createDate 创建时间：2018年9月25日 下午10:12:35
* 
*/
@Controller
@RequestMapping("/admin/links")
public class LinksController extends BaseController{
	@Autowired
	private LinksService linksService;
	/**
	 * 跳转友情链接页面
	 * @return
	 */
	@GetMapping
	public String links(Model model) {
		List<Link> lists=linksService.findLinks();
		model.addAttribute("links", lists);
		return "/admin/admin_links";
	}

	

}
