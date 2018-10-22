package com.songhaozhi.mayday.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhaozhi.mayday.mapper.generator.ArticleCategoryMapper;
import com.songhaozhi.mayday.mapper.generator.ArticleMapper;
import com.songhaozhi.mayday.mapper.generator.ArticleTagMapper;
import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.model.domain.ArticleCategory;
import com.songhaozhi.mayday.model.domain.ArticleTag;
import com.songhaozhi.mayday.service.ArticleService;

/**
 * @author 宋浩志
 * @createDate 创建时间：2018年10月15日 下午9:39:51
 * 
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ArticleCategoryMapper articleCategoryMapper;
	@Autowired
	private ArticleTagMapper articleTagMapper;
	/**
	 * 自动生成的mapper里配置了useGeneratedKeys="true" keyProperty="id"
	 * 如重新生成请复制过去
	 */
	@Override
	public void save(Article article, Long[] tags, Long[] categorys) {
		articleMapper.insert(article);
		for (Long cate : categorys) {
			ArticleCategory articleCategory = new ArticleCategory();
			articleCategory.setArticleId(article.getId());
			articleCategory.setCategoryId(cate);
			articleCategoryMapper.insert(articleCategory);
		}
		for (Long tag : tags) {
			ArticleTag articleTag = new ArticleTag();
			articleTag.setArticleId(article.getId());
			articleTag.setTagId(tag);
			articleTagMapper.insert(articleTag);
		}
	}
}
