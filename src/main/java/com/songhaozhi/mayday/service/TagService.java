package com.songhaozhi.mayday.service;

import java.util.List;

import com.songhaozhi.mayday.model.domain.Tag;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月25日
 * 
 */
public interface TagService {
	/**
	 * 查询所有标签
	 * 
	 * @return
	 */
	List<Tag> findTags() throws Exception;

	/**
	 * 根据tagid查询
	 * 
	 * @param tagId
	 * @return
	 */
	Tag findByTagId(int tagId) throws Exception;

	/**
	 * 保存
	 * 
	 * @param tag
	 */
	void save(Tag tag) throws Exception;

	/**
	 * 修改
	 * 
	 * @param tag
	 */
	void update(Tag tag) throws Exception;

	/**
	 * 删除
	 * 
	 * @param tagId
	 */
	void remove(int tagId) throws Exception;

}
