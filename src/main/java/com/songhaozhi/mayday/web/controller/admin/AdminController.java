package com.songhaozhi.mayday.web.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.MaydayConst;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年8月27日 上午11:15:50
 */
@RequestMapping(value = "/admin")
@Controller
public class AdminController extends BaseController {
	/**
	 * 后台首页
	 * 
	 * @return
	 */
	@RequestMapping(value = { "", "index" })
	public String index() {
		return "admin/admin_index";
	}

	/**
	 * 登录
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(HttpSession session, Model model) {
		User user = (User) session.getAttribute(MaydayConst.USER_SESSION_KEY);
		if (user != null) {
			return "redirect:/admin";
		}
		model.addAttribute("options", MaydayConst.options);
		return "admin/admin_login";
	}

	/**
	 * 清空session退出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/exitLogon")
	public String exitLogon(HttpSession session) {
		session.invalidate();
		return "admin/admin_login";
	}
}
