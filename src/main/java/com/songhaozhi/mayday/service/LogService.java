package com.songhaozhi.mayday.service;

import com.songhaozhi.mayday.model.domain.Log;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年9月28日 下午2:09:37
*/
public interface LogService {
	/**
	 * 保存日志
	 * @param log
	 */
	void save(Log log);
}
