package com.songhaozhi.mayday.web.controller.api;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.UserService;
import com.songhaozhi.mayday.web.controller.admin.BaseController;

import cn.hutool.crypto.SecureUtil;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年10月30日 下午2:36:35
*/
@RestController
@RequestMapping(value="/api/admin/profile")
public class ApiUserController extends BaseController{
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @param user
	 * @return 修改个人资料结果
	 */
	@PostMapping(value = "updateProfile")
	public JsonResult updateProfile(User user,HttpSession session) {
		try {
			userService.updateDatum(user);
			session.invalidate();
		} catch (Exception e) {
			log.error("修改资料：未知错误", e);
			return new JsonResult(MaydayEnums.ERROR.isFlag(), MaydayEnums.ERROR.getMessage());
		}
		return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(), MaydayEnums.PRESERVE_SUCCESS.getMessage());
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
	public JsonResult updatePwd(@RequestParam(value = "formerlyPwd") String formerlyPwd,
			@RequestParam(value = "nowPwd") String nowPwd, @RequestParam(value = "confirmPwd") String confirmPwd,
			@RequestParam(value = "userId") Integer userId) {
		if (StringUtils.isBlank(formerlyPwd) || StringUtils.isBlank(formerlyPwd) || StringUtils.isBlank(confirmPwd)) {
			return new JsonResult(MaydayEnums.OPERATION_ERROR.isFlag(), "请填写完整信息");
		}
		if (!nowPwd.equals(confirmPwd)) {
			return new JsonResult(MaydayEnums.OPERATION_ERROR.isFlag(), "两次密码不一样");
		}
		try {
			User user = userService.findByUserIdAndUserPwd(userId, SecureUtil.md5(formerlyPwd));
			if (user != null) {
				user.setUserPwd(SecureUtil.md5(confirmPwd));
				userService.updateDatum(user);
			} else {
				return new JsonResult(MaydayEnums.OPERATION_ERROR.isFlag(), "原密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("修改密码失败，系统错误");
			return new JsonResult(MaydayEnums.ERROR.isFlag(), "修改密码失败");
		}
		return new JsonResult(MaydayEnums.OPERATION_SUCCESS.isFlag(), "修改密码成功");
	}
}
