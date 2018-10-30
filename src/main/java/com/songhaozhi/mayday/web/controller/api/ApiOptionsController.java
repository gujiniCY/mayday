package com.songhaozhi.mayday.web.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.songhaozhi.mayday.model.domain.Options;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.OptionsService;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年10月30日 上午10:01:28
*/
@RequestMapping(value="/api/admin/options")
@RestController
public class ApiOptionsController {
	@Autowired
	private OptionsService optionsService;
	/**
	 * 保存设置
	 * @param map
	 * @return
	 */
	@PostMapping(value = "/save")
	public JsonResult save(@RequestParam Map<String, String> map) {
		try {
			optionsService.save(map);
			MaydayConst.options.clear();
			List<Options> ListMap = optionsService.selectMap();
			for (Options options : ListMap) {
				MaydayConst.options.put(options.getOptionName(), options.getOptionValue());
			}
		} catch (Exception e) {
			return new JsonResult(MaydayEnums.PRESERVE_ERROR.isFlag(), MaydayEnums.PRESERVE_ERROR.getMessage());
		}
		return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(), MaydayEnums.PRESERVE_SUCCESS.getMessage());
	}
}
