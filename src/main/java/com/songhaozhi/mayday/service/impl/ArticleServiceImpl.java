package com.songhaozhi.mayday.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.songhaozhi.mayday.model.dto.ArchiveBo;
import com.songhaozhi.mayday.service.ArticleService;

import cn.hutool.core.date.DateUtil;

/**
 * @author 宋浩志
 * @createDate 创建时间：2018年10月15日 下午9:39:51
 * 
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
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
	 * 自动生成的mapper里配置了useGeneratedKeys="true" keyProperty="id" 如重新生成请复制过去
	 */
	@Override
	public void save(Article article, Long[] tags, Long[] categorys) throws Exception {
		articleMapper.insert(article);
		if(categorys!=null) {
			for (Long cate : categorys) {
				ArticleCategory articleCategory = new ArticleCategory();
				articleCategory.setArticleId(article.getId());
				articleCategory.setCategoryId(cate);
				articleCategoryMapper.insert(articleCategory);
			}
		}
		if(tags!=null) {
			for (Long tag : tags) {
				ArticleTag articleTag = new ArticleTag();
				articleTag.setArticleId(article.getId());
				articleTag.setTagId(tag);
				articleTagMapper.insert(articleTag);
			}
		}
	}

	@Override
	public List<ArticleCustom> findAllArticle(int status) throws Exception {
		return articleMapperCustom.findAllArticle(status);
	}

	@Override
	public PageInfo<ArticleCustom> findPageArticle(int page, int limit, int status) throws Exception {
		PageHelper.startPage(page, limit);
		List<ArticleCustom> lists = articleMapperCustom.findPageArticle(status);
		return new PageInfo<>(lists);
	}

	@Override
	public Integer countByStatus(int status) throws Exception {
		return articleMapperCustom.countByStatus(status);
	}

	@Override
	public void recycle(int id, Integer integer) throws Exception {
		articleMapperCustom.updateStatus(id, integer);
	}

	@Override
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
	public ArticleCustom findByArticleId(Integer article_id) throws Exception {
		return articleMapperCustom.findByArticleId(article_id);
	}

	@Override
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
	public List<ArchiveBo> archives() throws Exception {
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
}
