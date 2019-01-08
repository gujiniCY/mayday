package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.mapper.generator.AttachmentMapper;
import com.songhaozhi.mayday.model.domain.Attachment;
import com.songhaozhi.mayday.model.domain.AttachmentExample;
import com.songhaozhi.mayday.service.AttachmentService;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月7日
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AttachmentServiceImpl implements AttachmentService {

	private static final String ATTACHMENTS_CACHE_NAME = "attachments";

	@Autowired
	private AttachmentMapper attachmentMapper;

	@Override
	@CacheEvict(value = ATTACHMENTS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void save(Attachment attachment) throws Exception {
		attachmentMapper.insert(attachment);
	}

	@Override
	public PageInfo<Attachment> getAttachment(int page, int limit) {
		PageHelper.startPage(page, limit);
		AttachmentExample example = new AttachmentExample();
		example.setOrderByClause("id desc");
		List<Attachment> lists = attachmentMapper.selectByExample(example);
		return new PageInfo<>(lists);
	}

	@Override
	@Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'findById'+#id")
	public Attachment findById(int id) {
		return attachmentMapper.selectByPrimaryKey(id);
	}

	@Override
	@CacheEvict(value = ATTACHMENTS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void deleteAttachment(int id) throws Exception {
		attachmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'countAttachment'")
	public List<Attachment> countAttachment() {
		return attachmentMapper.selectByExample(null);
	}

}
