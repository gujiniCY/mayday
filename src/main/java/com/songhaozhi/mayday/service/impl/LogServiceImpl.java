package com.songhaozhi.mayday.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songhaozhi.mayday.mapper.generator.LogMapper;
import com.songhaozhi.mayday.model.domain.Log;
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

}
