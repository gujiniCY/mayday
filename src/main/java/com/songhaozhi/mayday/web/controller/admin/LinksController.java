package com.songhaozhi.mayday.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.songhaozhi.mayday.model.domain.Link;
import com.songhaozhi.mayday.service.LinksService;

/**
 * @author 宋浩志
 * @createDate 创建时间：2018年9月25日 下午10:12:35
 * 友情链接
 */
@Controller
@RequestMapping(value="/admin/links")
public class LinksController extends BaseController {
	@Autowired
	private LinksService linksService;

	/**
	 * 跳转友情链接页面
	 * 
	 * @return
	 */
	@GetMapping
	public String links(Model model) {
		List<Link> lists = linksService.findLinks();
		model.addAttribute("links", lists);
		return "/admin/admin_links";
	}

	/**
	 * 进编辑页面
	 * 
	 * @param model
	 * @param linkId
	 * @return
	 */
	@GetMapping(value = "/edit")
	public String linksEdit(Model model, @RequestParam(value = "linkId") int linkId) {
		Link link = linksService.findByLindId(linkId);
		List<Link> lists = linksService.findLinks();
		model.addAttribute("links", lists);
		model.addAttribute("link", link);
		return "/admin/admin_links";
	}

	/**
	 * 保存 修改友情链接
	 * 
	 * @param link
	 * @param model
	 * @return
	 */
	@PostMapping(value = "save")
	public String save(Link link, Model model) {
		try {
			if (link.getLinkId() == null) {
				linksService.save(link);
			} else {
				linksService.update(link);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/links";
	}

	@GetMapping(value = "remove")
	public String remove(@RequestParam(value = "linkId") int linkId) {
		try {
			linksService.remove(linkId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/links";
	}

}
