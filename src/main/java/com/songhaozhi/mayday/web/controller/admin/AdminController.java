package com.songhaozhi.mayday.web.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.UserService;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年8月27日 上午11:15:50
 */
@RequestMapping("/admin")
@Controller
public class AdminController extends BaseController {
	@Autowired
	private UserService userService;

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
	public String login(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return "redirect:/admin";
		}
		return "admin/admin_login";
	}

	/**
	 * 验证
	 * 
	 * @param userName
	 * @param userPwd
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "getLogin")
	@ResponseBody
	public JsonResult getLogin(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "userPwd") String userPwd, HttpSession session) {
		User user = userService.getByNameAndPwd(userName, userPwd);
		try {
			if (user != null) {
				session.setAttribute("user", user);
				log.info(userName + "登录成功");
				return new JsonResult(true, MaydayEnums.SUCCESS.getCode(), "登录成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("登录失败，系统错误！");
		}
		return new JsonResult(false,MaydayEnums.ERROR.getCode(), "登录失败");
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
