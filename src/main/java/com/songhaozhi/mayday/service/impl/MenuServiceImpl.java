package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songhaozhi.mayday.mapper.generator.MenuMapper;
import com.songhaozhi.mayday.model.domain.Menu;
import com.songhaozhi.mayday.service.MenuService;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年12月18日 下午4:12:59
*/
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> findMenus() {
		return menuMapper.selectByExample(null);
	}

}
