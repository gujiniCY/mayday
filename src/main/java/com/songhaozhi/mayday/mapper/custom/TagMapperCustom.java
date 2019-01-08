package com.songhaozhi.mayday.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月27日 下午4:16:50
 */
public interface TagMapperCustom {

	List<Integer> selectByarticleId(Integer id);

	void delete(@Param(value = "list") List<Integer> tagList, @Param(value = "articleId") Integer articleId);

}
