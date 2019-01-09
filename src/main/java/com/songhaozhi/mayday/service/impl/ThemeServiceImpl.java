package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.mapper.custom.ThemeMapperCustom;
import com.songhaozhi.mayday.mapper.generator.ThemeMapper;
import com.songhaozhi.mayday.model.domain.Theme;
import com.songhaozhi.mayday.model.domain.ThemeExample;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.ThemeStatus;
import com.songhaozhi.mayday.service.ThemeService;

import cn.hutool.core.date.DateUtil;

/**
 * @author 宋浩志
 * @createDate 创建时间：2019年1月3日
 * 
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ThemeServiceImpl implements ThemeService {
	@Autowired
	private ThemeMapper themeMapper;
	@Autowired
	private ThemeMapperCustom themeMapperCustom;
	@Override
	public PageInfo<Theme> findPageTheme(int page, int limit) {
		PageHelper.startPage(page, limit);
		ThemeExample themeExample = new ThemeExample();
		themeExample.setOrderByClause("id desc");
		List<Theme> lists = themeMapper.selectByExample(themeExample);
		return new PageInfo<>(lists);
	}

	@Override
	public void saveTheme(Theme theme) {
		theme.setCreateTime(DateUtil.date());
		themeMapper.insertSelective(theme);
	}

	@Override
	public void remove(int id) {
		themeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Theme findByThemeName(String themeName) {
		ThemeExample themeExample = new ThemeExample();
		ThemeExample.Criteria criteria = themeExample.createCriteria();
		criteria.andThemeNameEqualTo(themeName);
		List<Theme> list=themeMapper.selectByExample(themeExample);
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public void themeEnabled(int id) {
		ThemeExample themeExample = new ThemeExample();
		ThemeExample.Criteria criteria = themeExample.createCriteria();
		criteria.andThemeStatusEqualTo(ThemeStatus.THEME_ENABLED.getValue());
		List<Theme> list=themeMapper.selectByExample(themeExample);
		//把已设置的主题状态改为未启用
		if(list.size()>0){
			themeMapperCustom.updateStatus(ThemeStatus.THEME_NOT_ENABLED.getValue(),list.get(0).getId());
		}
		//修改当前主题为启用
		themeMapperCustom.updateStatus(ThemeStatus.THEME_ENABLED.getValue(),id);
	}

	@Override
	public String getEnabledTheme() {
		ThemeExample themeExample = new ThemeExample();
		ThemeExample.Criteria criteria = themeExample.createCriteria();
		criteria.andThemeStatusEqualTo(ThemeStatus.THEME_ENABLED.getValue());
		List<Theme> list=themeMapper.selectByExample(themeExample);
		if(list.size()>0) {
			return list.get(0).getThemeName();
		}
		return null;
	}

}
