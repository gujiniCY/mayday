package com.songhaozhi.mayday.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author songhaozhi
 *
 */
public interface CategoryMapperCustom {

	List<Integer> selectByarticleId(Integer id);

	void delete(@Param(value = "list") List<Integer> cateList, @Param(value = "articleId") Integer articleId);

}