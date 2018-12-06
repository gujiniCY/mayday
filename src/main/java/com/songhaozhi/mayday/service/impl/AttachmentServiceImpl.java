package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.mapper.generator.AttachmentMapper;
import com.songhaozhi.mayday.model.domain.Attachment;
import com.songhaozhi.mayday.model.domain.AttachmentExample;
import com.songhaozhi.mayday.service.AttachmentService;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年9月7日 上午10:34:39
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class AttachmentServiceImpl implements AttachmentService {
	@Autowired
	private AttachmentMapper attachmentMapper;

	@Override
	public void save(Attachment attachment) throws Exception {
		attachmentMapper.insert(attachment);
	}

	@Override
	public PageInfo<Attachment> getAttachment(int page, int limit) throws Exception {
		PageHelper.startPage(page, limit);
		AttachmentExample example = new AttachmentExample();
		example.setOrderByClause("id desc");
		List<Attachment> lists = attachmentMapper.selectByExample(example);
		return new PageInfo<>(lists);
	}

	@Override
	public Attachment findById(int id) {
		return attachmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteAttachment(int id) throws Exception {
		attachmentMapper.deleteByPrimaryKey(id);
	}

}
