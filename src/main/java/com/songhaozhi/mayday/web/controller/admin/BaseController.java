package com.songhaozhi.mayday.web.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.service.LogService;

import cn.hutool.core.text.StrBuilder;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月6日
 */
public class BaseController {
	/** 日志 **/
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	protected LogService logService;
	// 默认主题
	public static String THEME = "pinghsu";

	/**
	 * 根据主题名称渲染页面
	 *
	 * @param pageName
	 *            pageName
	 * @return 返回拼接好的模板路径
	 */
	public String render(String pageName) {
		//加载主题
		if(MaydayConst.themeName!=null) {
			THEME=MaydayConst.themeName;
		}
		StrBuilder themeStr = new StrBuilder("themes/");
		themeStr.append(THEME);
		themeStr.append("/");
		return themeStr.append(pageName).toString();
	}

	/**
	 * 404页面
	 * 
	 * @return
	 */
	public String render_404() {
		return "error/404";
	}
}
