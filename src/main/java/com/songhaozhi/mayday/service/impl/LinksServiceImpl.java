package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhaozhi.mayday.mapper.generator.LinkMapper;
import com.songhaozhi.mayday.model.domain.Link;
import com.songhaozhi.mayday.service.LinksService;

/**
* @author 宋浩志
* @createDate 创建时间：2018年9月25日 下午10:12:35
* 
*/
@Service
public class LinksServiceImpl implements LinksService{
	
	@Autowired
	private LinkMapper linkMapper;

	@Override
	public List<Link> findLinks() {
		return linkMapper.selectByExample(null);
	}

	@Override
	public Link findByLindId(int linkId) {
		return linkMapper.selectByPrimaryKey(linkId);
	}

	@Override
	public void save(Link link) {
		linkMapper.insert(link);
	}

	@Override
	public void update(Link link) {
		linkMapper.updateByPrimaryKeySelective(link);
	}

	@Override
	public void remove(int linkId) {
		linkMapper.deleteByPrimaryKey(linkId);		
	}

}
