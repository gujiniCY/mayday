package com.songhaozhi.mayday.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhaozhi.mayday.mapper.generator.AttachmentMapper;
import com.songhaozhi.mayday.model.domain.Attachment;
import com.songhaozhi.mayday.service.AttachmentService;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年9月7日 上午10:34:39
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {
	@Autowired
	private AttachmentMapper attachmentMapper;

	@Override
	public void save(Attachment attachment) {
		attachmentMapper.insert(attachment);
	}

}
