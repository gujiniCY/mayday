package com.songhaozhi.mayday.service;

import java.util.List;

import com.songhaozhi.mayday.model.domain.Tag;

/**
* @author 作者
* @createDate 创建时间：2018年9月25日 下午10:12:22
* 
*/
public interface TagService {
	/**
	 * 查询所有标签
	 * @return
	 */
	List<Tag> findTags();
	/**
	 * 根据tagid查询
	 * @param tagId
	 * @return
	 */
	Tag findByTagId(int tagId);
	/**
	 * 保存
	 * @param tag
	 */
	void save(Tag tag);
	/**
	 * 修改
	 * @param tag
	 */
	void update(Tag tag);
	/**
	 * 删除
	 * @param tagId
	 */
	void remove(int tagId);
	
}
