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
	 * @param article 文章
	 * @param tags 标签
	 * @param categorys 分类
	 */
	void save(Article article, Long[] tags, Long[] categorys);
	/**
	 * 不分页查询所有文章
	 * @param status
	 * @return
	 */
	List<ArticleCustom> findAllArticle(int status);
	/**
	 * 分页查询所有文章
	 * @param limit 
	 * @param page 
	 * @param status 文章状态
	 * @return
	 */
	PageInfo<ArticleCustom> findPageArticle(int page, int limit, int status);
	/**
	 * 状态统计条数
	 * @param status 文章状态
	 * @return
	 */
	Integer countByStatus(int status);
	/**
	 * 修改文章状态为回收站
	 * @param id
	 */
	void remove(int id);
	/**
	 * 修改文章状态为回收站
	 * @param id
	 * @param integer 
	 */
	void recycle(int id, Integer integer);
	/**
	 * id查询文章
	 * @param article_id
	 * @return
	 */
	ArticleCustom findByArticleId(Integer article_id);

}
