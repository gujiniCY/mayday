package com.songhaozhi.mayday.service;

import java.util.List;
import java.util.Map;

import com.songhaozhi.mayday.model.domain.Options;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年10月12日 上午10:07:25
*/
public interface OptionsService {
	/**
	 * 保存多个
	 * @param map
	 */
	void save(Map<String, String> map);
	/**
	 * 所有设置选项
	 * @return
	 */
	List<Options> selectMap();
	/**
	 * 保存单个
	 * @param key
	 * @param value
	 */
	void saveOption(String key, String value);
	/**
	 * 删除
	 * @param options
	 */
	void delete(Options options);
	
}
