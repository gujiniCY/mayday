package com.songhaozhi.mayday.service;

import java.util.List;

import com.songhaozhi.mayday.model.domain.Menu;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年12月18日 下午4:12:49
*/
public interface MenuService {
	/**
	 * @return 所有菜单
	 */
	List<Menu> findMenus();

}
