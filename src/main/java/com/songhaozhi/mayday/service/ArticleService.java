package com.songhaozhi.mayday.service;

import com.songhaozhi.mayday.model.domain.Article;

/**
* @author 宋浩志
* @createDate 创建时间：2018年10月15日 下午9:39:38
* 
*/
public interface ArticleService {
	/**
	 * 保存文章
	 * @param article
	 */
	void save(Article article, Long[] tags, Long[] categorys);

}
