package com.songhaozhi.mayday.web.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Attachment;
import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.service.AttachmentService;
import com.songhaozhi.mayday.service.UserService;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年9月7日 上午9:17:05
 * 分类
 */
@RequestMapping(value="/admin/profile")
@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private AttachmentService attachmentService;

	/**
	 * 
	 * @param model
	 * @param session
	 * @return 返回个人资料页面
	 */
	@GetMapping
	public String profile(Model model, HttpSession session) {
		// 单用户
		User users = userService.findUser();
		model.addAttribute("user", users);
		return "/admin/admin_user";
	}
	/**
	 * 所有附件
	 * @param model
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping(value="/openChoice")
	public String openChoice(Model model,@RequestParam(value="id", defaultValue="none") String id,@RequestParam(value="page",defaultValue="1") int page,@RequestParam(value="limit",defaultValue="18") int limit) {
		PageInfo<Attachment> lists=attachmentService.getAttachment(page, limit);
		model.addAttribute("info", lists);
		model.addAttribute("id", id);
		return "/admin/open_choice";
	}
}
