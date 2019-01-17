package com.songhaozhi.mayday.service.impl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.songhaozhi.mayday.model.domain.ArticleExample;
import com.songhaozhi.mayday.model.domain.ArticleTag;
import com.songhaozhi.mayday.model.domain.ArticleTagExample;
import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.model.dto.ArchiveBo;
import com.songhaozhi.mayday.model.enums.ArticleStatus;
import com.songhaozhi.mayday.model.enums.PostType;
import com.songhaozhi.mayday.service.ArticleService;

import cn.hutool.core.date.DateUtil;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月15日
 * 
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ArticleServiceImpl implements ArticleService {

	private static final String ARTICLES_CACHE_KEY = "'article'";

	private static final String ARTICLES_CACHE_NAME = "articles";
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
	 * 自动生成的mapper里配置了useGeneratedKeys="true" keyProperty="id" 如重新生成请复制过去
	 */
	@Override
	@CacheEvict(value = ARTICLES_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void save(Article article, Long[] tags, Long[] categorys) throws Exception {
		articleMapper.insert(article);
		if (categorys != null) {
			Arrays.asList(categorys).stream().forEach(cate -> {
				ArticleCategory articleCategory = new ArticleCategory();
				articleCategory.setArticleId(article.getId());
				articleCategory.setCategoryId(cate);
				articleCategoryMapper.insert(articleCategory);
			});
		}
		if (tags != null) {
			Arrays.asList(tags).stream().forEach(tag -> {
				ArticleTag articleTag = new ArticleTag();
				articleTag.setArticleId(article.getId());
				articleTag.setTagId(tag);
				articleTagMapper.insert(articleTag);
			});
		}
	}

	@Override
	@Cacheable(value = ARTICLES_CACHE_NAME, key = "'findAllArticle'+#status+#post")
	public List<ArticleCustom> findAllArticle(int status,String post) {
		return articleMapperCustom.findAllArticle(status,post);
	}

	@Override
	@Cacheable(value = ARTICLES_CACHE_NAME, key = "'findPageArticle'+#page+#limit+#articleCustom.articleStatus+#articleCustom.articlePost")
	public PageInfo<ArticleCustom> findPageArticle(int page, int limit, ArticleCustom articleCustom) {
		PageHelper.startPage(page, limit);
		List<ArticleCustom> lists = articleMapperCustom.findPageArticle(articleCustom);
		return new PageInfo<>(lists);
	}

	@Override
	@Cacheable(value = ARTICLES_CACHE_NAME, key = "'Post_status'+#status+#post")
	public Integer countByStatus(Integer status, String post) {
		return articleMapperCustom.countByStatus(status, post);
	}

	@Override
	@CacheEvict(value = ARTICLES_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void recycle(int id, Integer integer) throws Exception {
		articleMapperCustom.updateStatus(id, integer);
	}

	@Override
	@CacheEvict(value = ARTICLES_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void remove(int id) throws Exception {
		// 删除文章表
		articleMapper.deleteByPrimaryKey(id);
		ArticleTagExample articleTagexample = new ArticleTagExample();
		ArticleTagExample.Criteria tagCriteria = articleTagexample.createCriteria();
		tagCriteria.andArticleIdEqualTo(id);
		ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
		ArticleCategoryExample.Criteria categoryCriteria = articleCategoryExample.createCriteria();
		categoryCriteria.andArticleIdEqualTo(id);
		// 删除分类表和标签表
		articleTagMapper.deleteByExample(articleTagexample);
		articleCategoryMapper.deleteByExample(articleCategoryExample);
	}

	@Override
	@Cacheable(value = ARTICLES_CACHE_NAME, key = "'findByArticleId'+#article_id")
	public ArticleCustom findByArticleId(Integer article_id) {
		return articleMapperCustom.findByArticleId(article_id);
	}

	@Override
	@CacheEvict(value = ARTICLES_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void update(Article article, Long[] tags, Long[] categorys) throws Exception {
		// 修改文章
		articleMapper.updateByPrimaryKeySelective(article);
		// 先查出关联的分类与标签
		List<Integer> tagList = tagMapperCustom.selectByarticleId(article.getId());
		List<Integer> cateList = categoryMapperCustom.selectByarticleId(article.getId());
		if (tagList != null && tagList.size() > 0) {
			// 然后删除
			tagMapperCustom.delete(tagList, article.getId());
		}
		if (cateList != null && cateList.size() > 0) {
			categoryMapperCustom.delete(cateList, article.getId());
		}
		// 再添加
		// 鬼知道我最开始为什么这样子设计。。。等到都写完了就不愿意改了，先用着吧
		if (categorys != null) {
			Arrays.asList(categorys).stream().forEach(cate -> {
				ArticleCategory articleCategory = new ArticleCategory();
				articleCategory.setArticleId(article.getId());
				articleCategory.setCategoryId(cate);
				articleCategoryMapper.insert(articleCategory);
			});
		}
		if (tags != null) {
			Arrays.asList(tags).stream().forEach(tag -> {
				ArticleTag articleTag = new ArticleTag();
				articleTag.setArticleId(article.getId());
				articleTag.setTagId(tag);
				articleTagMapper.insert(articleTag);
			});
		}
	}

	@Override
	@Cacheable(value = ARTICLES_CACHE_NAME, key = ARTICLES_CACHE_KEY)
	public List<ArchiveBo> archives() {
		// 查询文章表各个时间段的文章数量 分别为DATE->时间段 count->文章数量
		List<ArchiveBo> listforArchiveBo = articleMapperCustom.findDateAndCount();
		if (listforArchiveBo != null) {
			for (ArchiveBo archiveBo : listforArchiveBo) {
				ArticleExample example = new ArticleExample();
				// 在EXAMPLE对象中存放article_status和article_post
				ArticleExample.Criteria criteria = example.createCriteria().andArticleStatusEqualTo(0)
						.andArticlePostEqualTo("post");
				example.setOrderByClause("article_newstime desc");
				String date = archiveBo.getDate();
				Date sd = DateUtil.parse(date, "yyyy年MM月");
				// 在criteria对象中放入article_newstime大于或者等于的值
				criteria.andArticleNewstimeGreaterThanOrEqualTo(sd);
				Calendar cal = Calendar.getInstance();
				// 判断获取的时间的月份是否小于12
				if (sd.getMonth() < 12) {
					cal.setTime(sd);
					// 月份 +1
					cal.add(Calendar.MONTH, +1);
				} else {
					cal.setTime(sd);
					// 年 +1
					cal.add(Calendar.YEAR, +1);
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
				String date2 = sdf.format(cal.getTime());
				Date date3 = DateUtil.parse(date2, "yyyy年MM月");
				// 在criteria对象中放入article_newstime小于的值
				criteria.andArticleNewstimeLessThan(date3);
				List<Article> articles = articleMapper.selectByExample(example);
				archiveBo.setArticles(articles);
			}
		}
		return listforArchiveBo;
	}

	@Override
	@Cacheable(value = ARTICLES_CACHE_NAME, key = "'articleUrlInt'+#articleUrl")
	public int findRepeatByUrl(String articleUrl) {
		return articleMapperCustom.findRepeatByUrl(articleUrl);
	}

	@Override
	@Cacheable(value = ARTICLES_CACHE_NAME, key = "'articleUrl'+#articleUrl")
	public ArticleCustom findByArticleUrl(String articleUrl) {
		return articleMapperCustom.findByArticleUrl(articleUrl);
	}

	@Override
	@Cacheable(value = ARTICLES_CACHE_NAME, key = "'findArtileByCategory'+#page+#limit+#category.categoryUrl")
	public PageInfo<ArticleCustom> findArtileByCategory(int page, int limit, Category category,int status) {
		PageHelper.startPage(page, limit);
		List<ArticleCustom> list = articleMapperCustom.findArtileByCategory(category,status);
		return new PageInfo<>(list);
	}

	@Override
	@Cacheable(value = ARTICLES_CACHE_NAME, key = "'findArtileByTag'+#page+#limit+#status")
	public PageInfo<ArticleCustom> findArtileByTag(Integer page, Integer limit, Tag tag,int status) {
		PageHelper.startPage(page, limit);
		List<ArticleCustom> list = articleMapperCustom.findArtileByTag(tag,status);
		return new PageInfo<>(list);
	}

	@Override
	@Cacheable(value = ARTICLES_CACHE_NAME, key = "'findArticleByKeywords'+#keywords+#page+#limit")
	public PageInfo<Article> findArticleByKeywords(String keywords, Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		ArticleExample articleExample = new ArticleExample();
		ArticleExample.Criteria criteria = articleExample.createCriteria();
		criteria.andArticlePostEqualTo(PostType.POST_TYPE_POST.getValue());
		criteria.andArticleStatusEqualTo(ArticleStatus.PUBLISH.getStatus());
		criteria.andArticleTitleLike("%" + keywords + "%");
		articleExample.setOrderByClause("article_newstime desc");
		List<Article> list = articleMapper.selectByExample(articleExample);
		return new PageInfo<>(list);
	}

	@Override
	@CacheEvict(value = ARTICLES_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void updateArticleViews(Article article) {
		articleMapper.updateByPrimaryKeySelective(article);		
	}
}
