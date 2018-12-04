package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.mapper.custom.ArticleMapperCustom;
import com.songhaozhi.mayday.mapper.custom.CategoryMapperCustom;
import com.songhaozhi.mayday.mapper.custom.TagMapperCustom;
import com.songhaozhi.mayday.mapper.generator.ArticleCategoryMapper;
import com.songhaozhi.mayday.mapper.generator.ArticleMapper;
import com.songhaozhi.mayday.mapper.generator.ArticleTagMapper;
import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.model.domain.ArticleCategory;
import com.songhaozhi.mayday.model.domain.ArticleCategoryExample;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.ArticleTag;
import com.songhaozhi.mayday.model.domain.ArticleTagExample;
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
	private ArticleTagMapper articleTagMapper;
	@Autowired
	private ArticleCategoryMapper articleCategoryMapper;
	@Autowired
	private ArticleMapperCustom articleMapperCustom;
	@Autowired
	private TagMapperCustom tagMapperCustom;
	@Autowired
	private CategoryMapperCustom categoryMapperCustom;
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
	
	@Override
	public List<ArticleCustom> findAllArticle(int status) {
		return articleMapperCustom.findAllArticle(status);
	}

	@Override
	public PageInfo<ArticleCustom> findPageArticle( int page, int limit, int status) {
		PageHelper.startPage(page, limit);
		List<ArticleCustom> lists=articleMapperCustom.articleMapperCustom(status);
		return new PageInfo<>(lists);
	}

	@Override
	public Integer countByStatus(int status) {
		return articleMapperCustom.countByStatus(status);
	}

	@Override
	public void recycle(int id, Integer integer) {
		articleMapperCustom.updateStatus(id,integer);
	}

	@Override
	public void remove(int id) {
		//删除文章表
		articleMapper.deleteByPrimaryKey(id);
		ArticleTagExample articleTagexample=new ArticleTagExample();
		ArticleTagExample.Criteria tagCriteria =articleTagexample.createCriteria();
		tagCriteria.andArticleIdEqualTo(id);
		ArticleCategoryExample articleCategoryExample=new ArticleCategoryExample();
		ArticleCategoryExample.Criteria categoryCriteria=articleCategoryExample.createCriteria();
		categoryCriteria.andArticleIdEqualTo(id);
		//删除分类表和标签表
		articleTagMapper.deleteByExample(articleTagexample);
		articleCategoryMapper.deleteByExample(articleCategoryExample);
	}

	@Override
	public ArticleCustom findByArticleId(Integer article_id) {
		return articleMapperCustom.findByArticleId(article_id);
	}

	@Override
	public void update(Article article, Long[] tags, Long[] categorys) throws Exception{
		//修改文章
		articleMapper.updateByPrimaryKeySelective(article);
		//先查出关联的分类与标签
		List<Integer> tagList=tagMapperCustom.selectByarticleId(article.getId());
		List<Integer> cateList=categoryMapperCustom.selectByarticleId(article.getId());
		if(tagList!=null && tagList.size()>0) {
			//然后删除
			tagMapperCustom.delete(tagList);
		}
		if(cateList!=null && cateList.size()>0) {
			categoryMapperCustom.delete(cateList);
		}
		//再添加
		//鬼知道我最开始为什么这样子设计。。。等到都写完了就不愿意改了，先用着吧
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
