package com.songhaozhi.mayday.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年9月7日 上午10:35:55
 */
@RequestMapping("/admin/attachment")
@Controller
public class AttachmentController {
	@GetMapping
	public String attachment() {
		return "/admin/admin_attachment";
	}

}
