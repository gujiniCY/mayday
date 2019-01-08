package com.songhaozhi.mayday.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Log;
import com.songhaozhi.mayday.service.LogService;

/**
 * @author : 宋浩志
 * @createDate : 2018年12月26日
 */
@Controller
@RequestMapping("/admin/logs")
public class LogsController extends BaseController {
	@Autowired
	private LogService logService;

	/**
	 * 分页查看日志
	 * 
	 * @param model
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping
	public String logs(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {
		PageInfo<Log> info = logService.findLogs(page, limit);
		model.addAttribute("logs", info);
		return "/admin/part/view_logs";
	}

	/**
	 * 清除所有日志
	 * 
	 * @return
	 */
	@GetMapping("/clear")
	public String clear() {
		try {
			logService.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin";
	}

}
