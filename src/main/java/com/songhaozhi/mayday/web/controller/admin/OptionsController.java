package com.songhaozhi.mayday.web.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.OptionsService;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年10月12日 上午10:08:40
*/
@RequestMapping("/admin/option")
@Controller
public class OptionsController extends BaseController{
	@Autowired
	private OptionsService optionsService;
	@GetMapping
	public String option(Model model) {
		Map<String, Object> map = optionsService.findAll();
		model.addAttribute("options", map); 
		return "/admin/admin_options";
	}
	
	@PostMapping(value="save")
	@ResponseBody
	public JsonResult save(@RequestParam Map<String, Object> map) {
		try {
			optionsService.save(map);
		} catch (Exception e) {
			return new JsonResult(MaydayEnums.PRESERVE_ERROR.isFlag(),MaydayEnums.PRESERVE_ERROR.getMessage());
		}
		return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(),MaydayEnums.PRESERVE_SUCCESS.getMessage());
	}

}
