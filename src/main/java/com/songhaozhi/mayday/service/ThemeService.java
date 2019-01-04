package com.songhaozhi.mayday.service;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Theme;

/**
* @author 宋浩志
* @createDate 创建时间：2019年1月3日
* 
*/
public interface ThemeService {

	PageInfo<Theme> findPageTheme(int page, int limit);

	void saveTheme(Theme theme);

	void remove(int id);

}
