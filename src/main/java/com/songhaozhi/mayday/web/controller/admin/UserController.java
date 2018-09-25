package com.songhaozhi.mayday.web.controller.admin;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.UserService;

import cn.hutool.crypto.SecureUtil;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年9月7日 上午9:17:05
 */
@RequestMapping("/admin/profile")
@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

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
	 * 
	 * @param user
	 * @return 修改个人资料结果
	 */
	@PostMapping(value = "updateProfile")
	@ResponseBody
	public JsonResult updateProfile(User user) {
		try {
			userService.updateDatum(user);
		} catch (Exception e) {
			log.error("修改资料：未知错误", e);
			return new JsonResult(false, MaydayEnums.ERROR.getCode(), MaydayEnums.ERROR.getMessage());
		}
		return new JsonResult(true, MaydayEnums.PRESERVE_SUCCESS.getCode(), MaydayEnums.PRESERVE_SUCCESS.getMessage());
	}

	/**
	 * 修改密码
	 * 
	 * @param formerlyPwd
	 *            原密码
	 * @param nowPwd
	 *            新密码
	 * @param confirmPwd
	 *            确认新密码
	 * @param userId
	 *            用户id
	 * @return
	 */
	@PostMapping(value = "updatePwd")
	@ResponseBody
	public JsonResult updatePwd(@RequestParam(value = "formerlyPwd") String formerlyPwd,
			@RequestParam(value = "nowPwd") String nowPwd, @RequestParam(value = "confirmPwd") String confirmPwd,
			@RequestParam(value = "userId") Integer userId) {
		if (StringUtils.isBlank(formerlyPwd) || StringUtils.isBlank(formerlyPwd) || StringUtils.isBlank(confirmPwd)) {
			return new JsonResult(false, MaydayEnums.OPERATION_ERROR.getCode(), "请填写完整信息");
		}
		if (!nowPwd.equals(confirmPwd)) {
			return new JsonResult(false, MaydayEnums.OPERATION_ERROR.getCode(), "两次密码不一样");
		}
		try {
			User user = userService.findByUserIdAndUserPwd(userId, SecureUtil.md5(formerlyPwd));
			if (user != null) {
				user.setUserPwd(SecureUtil.md5(confirmPwd));
				userService.updateDatum(user);
			} else {
				return new JsonResult(false, MaydayEnums.OPERATION_ERROR.getCode(), "原密码错误");
			}
		} catch (Exception e) {
			log.error("修改密码失败，系统错误");
			return new JsonResult(false, MaydayEnums.ERROR.getCode(), "修改密码失败");
		}
		return new JsonResult(true, MaydayEnums.OPERATION_SUCCESS.getCode(), "修改密码成功");
	}
}
