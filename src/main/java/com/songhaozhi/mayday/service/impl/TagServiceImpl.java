package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhaozhi.mayday.mapper.generator.TagMapper;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.service.TagService;

/**
* @author 宋浩志
* @createDate 创建时间：2018年9月25日 下午10:12:35
* 
*/
@Service
public class TagServiceImpl implements TagService{
	
	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<Tag> findTags() {
		return tagMapper.selectByExample(null);
	}

	@Override
	public Tag findByTagId(int linkId) {
		return tagMapper.selectByPrimaryKey(linkId);
	}

	@Override
	public void save(Tag tag) {
		tagMapper.insert(tag);
	}

	@Override
	public void update(Tag tag) {
		tagMapper.updateByPrimaryKeySelective(tag);
	}

	@Override
	public void remove(int tagId) {
		tagMapper.deleteByPrimaryKey(tagId);		
	}

}
