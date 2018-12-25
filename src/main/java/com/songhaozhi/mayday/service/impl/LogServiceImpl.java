package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.mapper.generator.LogMapper;
import com.songhaozhi.mayday.model.domain.Log;
import com.songhaozhi.mayday.model.domain.LogExample;
import com.songhaozhi.mayday.model.domain.MenuExample;
import com.songhaozhi.mayday.service.LogService;

/**
* @author : 宋浩志
* @createDate : 2018年9月28日
*/
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class LogServiceImpl implements LogService{
	
	@Autowired
	private LogMapper logMapper;

	@Override
	public void save(Log log) {
		logMapper.insert(log);		
	}

	@Override
	public PageInfo<Log> findLogs(int page, int limit) {
		PageHelper.startPage(page, limit);
		LogExample example=new LogExample();
		example.setOrderByClause("log_id");
		List<Log> logs=logMapper.selectByExample(example);
		return new PageInfo<>(logs);
	}

}
