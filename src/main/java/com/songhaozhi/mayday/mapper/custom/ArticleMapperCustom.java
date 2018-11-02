package com.songhaozhi.mayday.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.songhaozhi.mayday.model.domain.ArticleCustom;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年11月1日 下午2:54:48
*/
public interface ArticleMapperCustom {

	List<ArticleCustom> articleMapperCustom(@Param(value="status") int status);

	List<ArticleCustom> findAllArticle(@Param(value="status") int status);

	Integer countByStatus(@Param(value="status") int status);

	void updateStatus(@Param(value="id")int id, @Param(value="status")int status);

}
