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

}
