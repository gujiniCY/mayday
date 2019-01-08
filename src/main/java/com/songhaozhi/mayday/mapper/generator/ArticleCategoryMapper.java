package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.domain.ArticleCategory;
import com.songhaozhi.mayday.model.domain.ArticleCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleCategoryMapper {
	long countByExample(ArticleCategoryExample example);

	int deleteByExample(ArticleCategoryExample example);

	int insert(ArticleCategory record);

	int insertSelective(ArticleCategory record);

	List<ArticleCategory> selectByExample(ArticleCategoryExample example);

	int updateByExampleSelective(@Param("record") ArticleCategory record,
			@Param("example") ArticleCategoryExample example);

	int updateByExample(@Param("record") ArticleCategory record, @Param("example") ArticleCategoryExample example);
}