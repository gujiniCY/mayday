package com.songhaozhi.mayday.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhaozhi.mayday.mapper.generator.LogMapper;
import com.songhaozhi.mayday.model.domain.Log;
import com.songhaozhi.mayday.service.LogService;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年9月28日 下午2:09:53
*/
@Service
public class LogServiceImpl implements LogService{
	
	@Autowired
	private LogMapper logMapper;

	@Override
	public void save(Log log) {
		logMapper.insert(log);		
	}

}
