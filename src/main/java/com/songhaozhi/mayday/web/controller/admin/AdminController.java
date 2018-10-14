package com.songhaozhi.mayday.web.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhaozhi.mayday.model.domain.Log;
import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.LogConstant;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.UserService;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.servlet.ServletUtil;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年8月27日 上午11:15:50
 */
@RequestMapping(value = "/admin")
@Controller
public class AdminController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private HttpServletRequest request;

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
		User user = (User) session.getAttribute(MaydayConst.USER_SESSION_KEY);
		if (user != null) {
			return "redirect:/admin";
		}
		return "admin/admin_login";
	}

	/**
	 * 验证
	 * 
	 * @param userName
	 *            用户名
	 * @param userPwd
	 *            用户密码
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "getLogin")
	@ResponseBody
	public JsonResult getLogin(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "userPwd") String userPwd, HttpSession session) {
		// 禁止时间10分子
		int inhibitTime = 10;
		// 为true禁止登录
		String flag = "true";
		// 错误总次数5次
		Integer errorCount = 5;
		// 已注册用户
		User users = userService.findUser();
		// 判断账户是否被禁用十分钟
		Date date = null;
		if (users.getLoginLastTime() != null) {
			date = users.getLoginLastTime();
		}
		// 计算两个日期之间的时间差
		long between = DateUtil.between(date, DateUtil.date(), DateUnit.MINUTE);
		if (StringUtils.equals(users.getLoginEnable(), flag) && (between < inhibitTime)) {
			return new JsonResult(false, "账户被禁止登录10分钟，请稍后重试");
		}
		// 验证用户名密码
		User user = userService.getByNameAndPwd(userName, SecureUtil.md5(userPwd));
		try {
			// 修改最后登录时间
			userService.updateLoginLastTime(DateUtil.date(), users.getUserId());
			if (user != null) {
				session.setAttribute(MaydayConst.USER_SESSION_KEY, user);
				// 登录成功重置用户状态为正常
				userService.updateUserNormal(user.getUserId());
				// 添加登录日志
				logService.save(new Log(LogConstant.LOGIN, LogConstant.LOGIN_SUCCES, ServletUtil.getClientIP(request),
						DateUtil.date()));
				log.info(userName + "登录成功");
				return new JsonResult(true, "登录成功");
			} else {
				Integer error = userService.updateError();
				if (error >= errorCount) {
					userService.updateLoginEnable("true");
				}
				// 添加失败日志
				logService.save(new Log(LogConstant.LOGIN, LogConstant.LOGIN_ERROR, ServletUtil.getClientIP(request),
						DateUtil.date()));
				return new JsonResult(false,
						"用户名或密码错误！你还有" + (5 - error) + "次机会");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("登录失败，系统错误！");
			return new JsonResult(false, "未知错误！");
		}
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
