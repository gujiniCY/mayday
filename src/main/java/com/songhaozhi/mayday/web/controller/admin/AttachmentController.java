package com.songhaozhi.mayday.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Attachment;
import com.songhaozhi.mayday.service.AttachmentService;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年9月7日 上午10:35:55 附件
 */
@RequestMapping(value = "/admin/attachment")
@Controller
public class AttachmentController extends BaseController {
	@Autowired
	private AttachmentService attachmentService;

	/**
	 * 跳转附件页面并显示所有图片
	 * 
	 * @return
	 */
	@GetMapping
	public String attachment(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "18") int limit) {
		PageInfo<Attachment> info = attachmentService.getAttachment(page, limit);
		model.addAttribute("info", info);
		return "/admin/admin_attachment";
	}

	/**
	 * 附件详情
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "viewDetails")
	public String viewDetails(Model model, @RequestParam(value = "id") int id) {
		Attachment attachment = attachmentService.findById(id);
		model.addAttribute("attachment", attachment);
		return "/admin/view_details";
	}

}
