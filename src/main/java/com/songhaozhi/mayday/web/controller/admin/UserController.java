package com.songhaozhi.mayday.web.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.UserService;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年9月7日 上午9:17:05
 */
@RequestMapping("/admin/profile")
@Controller
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String profile(Model model,HttpSession session) {
		User user=(User) session.getAttribute(MaydayConst.USER_SESSION_KEY);
		User users= userService.findUser(user.getUserId());
		model.addAttribute("user",users);
		return "/admin/admin_user";
	}
	
	@PostMapping(value="updateProfile")
	@ResponseBody
	public JsonResult updateProfile(User user) {
		try {
			userService.updateDatum(user);
		} catch (Exception e) {
			  log.error("修改资料：未知错误", e);
			return new JsonResult(false,MaydayEnums.PRESERVE_ERROR.getCode(),MaydayEnums.PRESERVE_ERROR.getMessage());
		}
		return new JsonResult(true,MaydayEnums.PRESERVE_SUCCESS.getCode(),MaydayEnums.PRESERVE_SUCCESS.getMessage());
	}
	
}
