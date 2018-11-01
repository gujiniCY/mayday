package com.songhaozhi.mayday.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.model.domain.ArticleCustom;

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
	/**
	 * 不分页查询所有文章
	 * @param value
	 * @return
	 */
	List<Article> findAllArticle(String value);
	/**
	 * 分页查询所有文章
	 * @param articleCustom
	 * @param limit 
	 * @param page 
	 * @return
	 */
	PageInfo<ArticleCustom> findPageArticle(ArticleCustom articleCustom, int page, int limit);

}
