package com.songhaozhi.mayday.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.dto.ArchiveBo;

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
	void save(Article article, Long[] tags, Long[] categorys) throws Exception;
	/**
	 * 不分页查询所有文章
	 * @param status
	 * @return
	 */
	List<ArticleCustom> findAllArticle(int status) throws Exception;
	/**
	 * 分页查询所有文章
	 * @param limit 
	 * @param page 
	 * @param status 文章状态
	 * @return
	 */
	PageInfo<ArticleCustom> findPageArticle(int page, int limit, int status) throws Exception;
	/**
	 * 状态统计条数
	 * @param status 文章状态
	 * @return
	 */
	Integer countByStatus(int status) throws Exception;
	/**
	 * 修改文章状态为回收站
	 * @param id
	 */
	void remove(int id) throws Exception;
	/**
	 * 修改文章状态为回收站
	 * @param id
	 * @param integer 
	 */
	void recycle(int id, Integer integer) throws Exception;
	/**
	 * id查询文章
	 * @param article_id
	 * @return
	 */
	ArticleCustom findByArticleId(Integer article_id) throws Exception;
	/**
	 * 修改文章
	 * @param article
	 * @param tags
	 * @param categorys
	 * @throws Exception 
	 */
	void update(Article article, Long[] tags, Long[] categorys) throws Exception;

	/**
	 * 归档
	 * @return
	 */
	List<ArchiveBo> archives() throws Exception;
}
