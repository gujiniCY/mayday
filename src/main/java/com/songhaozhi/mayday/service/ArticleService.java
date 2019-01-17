package com.songhaozhi.mayday.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.model.dto.ArchiveBo;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月15日
 */
public interface ArticleService {
	/**
	 * 保存文章
	 * 
	 * @param article
	 *            文章
	 * @param tagsName
	 *            标签id
	 * @param categorys
	 *            分类id
	 */
	void save(Article article, Long[] tagsName, Long[] categorys) throws Exception;

	/**
	 * 不分页查询所有文章
	 * 
	 * @param status
	 * @param string 
	 * @return
	 */
	List<ArticleCustom> findAllArticle(int status, String post);

	/**
	 * 分页查询所有文章
	 * 
	 * @param limit
	 * @param page
	 * @param articleCustom
	 *            文章对象
	 * @return
	 */
	PageInfo<ArticleCustom> findPageArticle(int page, int limit, ArticleCustom articleCustom);

	/**
	 * 状态统计条数
	 * 
	 * @param status
	 *            状态
	 * @param post
	 *            类型
	 * @return
	 */
	Integer countByStatus(Integer status, String post);

	/**
	 * 修改文章状态为回收站
	 * 
	 * @param id
	 */
	void remove(int id) throws Exception;

	/**
	 * 修改文章状态为回收站
	 * 
	 * @param id
	 * @param integer
	 */
	void recycle(int id, Integer integer) throws Exception;

	/**
	 * id查询文章
	 * 
	 * @param article_id
	 * @return
	 */
	ArticleCustom findByArticleId(Integer article_id);

	/**
	 * 修改文章
	 * 
	 * @param article
	 * @param tags
	 *            标签id
	 * @param categorys
	 *            分类id
	 * @throws Exception
	 */
	void update(Article article, Long[] tags, Long[] categorys) throws Exception;

	/**
	 * 归档
	 * 
	 * @return
	 */
	List<ArchiveBo> archives();

	/**
	 * 统计重复链接
	 * 
	 * @param articleUrl
	 *            文章链接
	 * @return
	 */
	int findRepeatByUrl(String articleUrl);

	/**
	 * 文章链接查询
	 * 
	 * @param articleUrl
	 * @return 文章
	 */
	ArticleCustom findByArticleUrl(String articleUrl);

	/**
	 * 分页查询分类下的所有文章
	 * 
	 * @param page
	 * @param limit
	 * @param category
	 * @param status 文章状态
	 * @return
	 */
	PageInfo<ArticleCustom> findArtileByCategory(int page, int limit, Category category, int status);

	/**
	 * 分页查询标签下的所有文章
	 * 
	 * @param page
	 * @param size
	 * @param tag
	 * @param status 文章状态
	 * @return
	 */
	PageInfo<ArticleCustom> findArtileByTag(Integer page, Integer limit, Tag tag, int status);

	/**
	 * 标题分页搜索文章
	 * 
	 * @param keywords
	 * @param page
	 * @param size
	 * @return
	 */
	PageInfo<Article> findArticleByKeywords(String keywords, Integer page, Integer limit);
	/**
	 * 修改文章点击数
	 * @param article
	 */
	void updateArticleViews(Article article);
}
