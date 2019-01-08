package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songhaozhi.mayday.mapper.generator.TagMapper;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.model.domain.TagExample;
import com.songhaozhi.mayday.service.TagService;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月25日
 * 
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class TagServiceImpl implements TagService {
	private static final String TAGS_CACHE_KEY = "'tag'";
	private static final String TAGS_CACHE_NAME = "tags";
	@Autowired
	private TagMapper tagMapper;

	@Override
	@Cacheable(value = TAGS_CACHE_NAME, key = TAGS_CACHE_KEY)
	public List<Tag> findTags() {
		return tagMapper.selectByExample(null);
	}

	@Override
	public Tag findByTagId(int linkId) {
		return tagMapper.selectByPrimaryKey(linkId);
	}

	@Override
	@CacheEvict(value = TAGS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void save(Tag tag) throws Exception {
		tagMapper.insert(tag);
	}

	@Override
	@CacheEvict(value = TAGS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void update(Tag tag) throws Exception {
		tagMapper.updateByPrimaryKeySelective(tag);
	}

	@Override
	@CacheEvict(value = TAGS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void remove(int tagId) throws Exception {
		tagMapper.deleteByPrimaryKey(tagId);
	}

	@Override
	public Tag findByTagUrl(String tagUrl) {
		TagExample tagExample = new TagExample();
		TagExample.Criteria criteria = tagExample.createCriteria();
		criteria.andTagUrlEqualTo(tagUrl);
		return tagMapper.selectByExample(tagExample).get(0);
	}

}
