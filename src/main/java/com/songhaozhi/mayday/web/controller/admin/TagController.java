package com.songhaozhi.mayday.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.service.TagService;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月25日 标签
 */
@Controller
@RequestMapping(value = "/admin/tag")
public class TagController extends BaseController {
	@Autowired
	private TagService tagService;

	/**
	 * 跳转标签页面
	 * 
	 * @return
	 */
	@GetMapping
	public String tag(Model model) {
		List<Tag> lists = tagService.findTags();
		model.addAttribute("tags", lists);
		return "admin/admin_tag";
	}

	/**
	 * 进编辑页面
	 * 
	 * @param model
	 * @param tagId
	 * @return
	 */
	@GetMapping(value = "/edit")
	public String edit(Model model, @RequestParam(value = "tagId") int tagId) {
		Tag tag = tagService.findByTagId(tagId);
		List<Tag> lists = tagService.findTags();
		model.addAttribute("tags", lists);
		model.addAttribute("tag", tag);
		return "admin/admin_tag";
	}

	/**
	 * 保存 修改标签
	 * 
	 * @param tag
	 * @param model
	 * @return
	 */
	@PostMapping(value = "save")
	public String save(Tag tag, Model model) {
		try {
			if (tag.getTagId() == null) {
				tagService.save(tag);
			} else {
				tagService.update(tag);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "redirect:/admin/tag";
	}

	/**
	 * 删除
	 * 
	 * @param tagId
	 * @return
	 */
	@GetMapping(value = "remove")
	public String remove(@RequestParam(value = "tagId") int tagId) {
		try {
			tagService.remove(tagId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "redirect:/admin/tag";
	}

}
