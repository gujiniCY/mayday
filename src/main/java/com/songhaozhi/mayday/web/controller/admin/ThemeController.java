package com.songhaozhi.mayday.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Log;
import com.songhaozhi.mayday.model.domain.Theme;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.LogConstant;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.ThemeService;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.servlet.ServletUtil;

/**
 * @author : 宋浩志
 * @createDate : 2019年1月3日
 */
@Controller
@RequestMapping("/admin/theme")
public class ThemeController extends BaseController {
	@Autowired
	private ThemeService themeService;
	/**
	 * 查看所有主题
	 * @param model
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping
	public String theme(Model model ,@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {
		PageInfo<Theme> info=themeService.findPageTheme(page,limit);
		model.addAttribute("info", info);
		return "/admin/admin_theme";
	}
	
	/**
	 * 保存主题
	 * @param theme
	 * @param request
	 * @return
	 */
	@PostMapping("/saveTheme")
	@ResponseBody
	public JsonResult saveTheme(Theme theme,HttpServletRequest request) {
		try {
			themeService.saveTheme(theme);
			//添加日志
			logService.save(new Log(LogConstant.PUBLISH_AN_THEME, LogConstant.SUCCESS, ServletUtil.getClientIP(request),
					DateUtil.date()));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(MaydayEnums.PRESERVE_ERROR.isFlag(),MaydayEnums.PRESERVE_ERROR.getMessage());
		}
		return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(),MaydayEnums.PRESERVE_SUCCESS.getMessage());
	}
	/**
	 * 删除主题
	 * @param id
	 * @param request
	 * @return
	 */
	@GetMapping("/remove")
	public String remove(int id,HttpServletRequest request) {
		try {
			themeService.remove(id);
			//添加日志
			logService.save(new Log(LogConstant.REMOVE_AN_THEME, LogConstant.SUCCESS, ServletUtil.getClientIP(request),
					DateUtil.date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/theme";
	}
}
