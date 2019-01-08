package com.songhaozhi.mayday.web.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhaozhi.mayday.model.domain.Options;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.OptionsService;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月12日
 */

@Controller
@RequestMapping("/admin/option")
public class OptionsController extends BaseController {
	@Autowired
	private OptionsService optionsService;

	/**
	 * 所有设置选项
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String option(Model model) {
		return "/admin/admin_options";
	}

	/**
	 * 保存设置
	 * 
	 * @param map
	 * @return
	 */
	@PostMapping(value = "/save")
	@ResponseBody
	public JsonResult save(@RequestParam Map<String, String> map) {
		try {
			optionsService.save(map);
			MaydayConst.options.clear();
			List<Options> listMap = optionsService.selectMap();
			for (Options options : listMap) {
				MaydayConst.options.put(options.getOptionName(), options.getOptionValue());
			}
		} catch (Exception e) {
			return new JsonResult(MaydayEnums.PRESERVE_ERROR.isFlag(), MaydayEnums.PRESERVE_ERROR.getMessage());
		}
		return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(), MaydayEnums.PRESERVE_SUCCESS.getMessage());
	}
}
