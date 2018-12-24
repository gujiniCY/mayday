package com.songhaozhi.mayday.service;

import com.songhaozhi.mayday.model.domain.Log;

/**
* @author : 宋浩志
* @createDate : 2018年9月28日
*/
public interface LogService {
	/**
	 * 保存日志
	 * @param log
	 */
	void save(Log log);
}
