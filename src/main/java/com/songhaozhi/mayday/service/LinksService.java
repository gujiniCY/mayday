package com.songhaozhi.mayday.service;

import java.util.List;

import com.songhaozhi.mayday.model.domain.Link;

/**
* @author 作者
* @createDate 创建时间：2018年9月25日 下午10:12:22
* 
*/
public interface LinksService {
	/**
	 * 查询所有友情链接
	 * @return
	 */
	List<Link> findLinks();
	/**
	 * 根据linkId查询
	 * @param linkId 友链id
	 * @return
	 */
	Link findByLindId(int linkId);
	/**
	 * 保存
	 * @param link
	 */
	void save(Link link);
	/**
	 * 修改
	 * @param link
	 */
	void update(Link link);
	/**
	 * 删除
	 * @param linkId
	 */
	void remove(int linkId);
	
}
