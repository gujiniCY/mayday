package com.songhaozhi.mayday.web.controller.admin;
/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年9月6日 下午3:09:57
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.songhaozhi.mayday.service.LogService;

public class BaseController {
	/** 日志 **/
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected LogService logService;
}
