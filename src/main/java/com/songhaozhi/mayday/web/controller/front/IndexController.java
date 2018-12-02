package com.songhaozhi.mayday.web.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.songhaozhi.mayday.web.controller.admin.BaseController;

/**
 * @author 宋浩志
 * @createDate 创建时间：2018年12月2日 下午5:12:40
 * 
 */
@RequestMapping(value = { "/", "index" })
@Controller
public class IndexController extends BaseController {

	/**
	 * 请求首页
	 *
	 * @param model
	 *            model
	 * @param i
	 * @return 模板路径
	 */
	@GetMapping
	public String index(Model model) {
		// 调用方法渲染首页
		return this.index(model, 1);
	}

	/**
	 * 首页分页
	 *
	 * @return 模板路径/themes/{theme}/index
	 */
	@GetMapping(value = "page/{page}")
	public String index(Model model, @PathVariable(value = "page") Integer page) {
		return this.render("index");
	}

}
