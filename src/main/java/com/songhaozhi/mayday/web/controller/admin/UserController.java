package com.songhaozhi.mayday.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.UserService;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年9月7日 上午9:17:05
 */
@RequestMapping("/admin/datum")
@Controller
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String datum() {
		return "/admin/admin_user";
	}
	
	@RequestMapping("/updateDatum")
	@ResponseBody
	public JsonResult updateDatum(User user) {
		try {
			userService.updateDatum(user);
		} catch (Exception e) {
			return new JsonResult(true,MaydayEnums.ERROR.getCode(),MaydayEnums.ERROR.getMessage());
		}
		return new JsonResult(true,MaydayEnums.SUCCESS.getCode(),MaydayEnums.SUCCESS.getMessage());
	}
	
}
