package com.songhaozhi.mayday.service;

import java.util.Map;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年10月12日 上午10:07:25
*/
public interface OptionsService {
	/**
	 * 保存
	 * @param map
	 */
	void save(Map<String, Object> map);
	/**
	 * 所有设置选项
	 * @return
	 */
	Map<String, Object> findAll();

}
