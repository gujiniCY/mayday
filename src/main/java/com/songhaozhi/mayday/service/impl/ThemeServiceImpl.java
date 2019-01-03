package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.mapper.generator.ThemeMapper;
import com.songhaozhi.mayday.model.domain.Theme;
import com.songhaozhi.mayday.model.domain.ThemeExample;
import com.songhaozhi.mayday.service.ThemeService;

/**
* @author 宋浩志
* @createDate 创建时间：2019年1月3日
* 
*/
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class ThemeServiceImpl implements ThemeService{
	@Autowired
	private ThemeMapper themeMapper;

	@Override
	public PageInfo<Theme> findPageTheme(int page, int limit) {
		PageHelper.startPage(page, limit);
		ThemeExample themeExample=new ThemeExample();
		themeExample.setOrderByClause("id desc");
		List<Theme> lists=themeMapper.selectByExample(themeExample);
		return new PageInfo<>(lists);
	}

	@Override
	public void saveTheme(Theme theme) {
		themeMapper.insert(theme);
	}
	
	

}
