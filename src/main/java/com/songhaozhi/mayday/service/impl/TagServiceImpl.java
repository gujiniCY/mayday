package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songhaozhi.mayday.mapper.generator.TagMapper;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.service.TagService;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月25日
 * 
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class TagServiceImpl implements TagService {

	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<Tag> findTags() throws Exception {
		return tagMapper.selectByExample(null);
	}

	@Override
	public Tag findByTagId(int linkId) throws Exception {
		return tagMapper.selectByPrimaryKey(linkId);
	}

	@Override
	public void save(Tag tag) throws Exception {
		tagMapper.insert(tag);
	}

	@Override
	public void update(Tag tag) throws Exception {
		tagMapper.updateByPrimaryKeySelective(tag);
	}

	@Override
	public void remove(int tagId) throws Exception {
		tagMapper.deleteByPrimaryKey(tagId);
	}

}
