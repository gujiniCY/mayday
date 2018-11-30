package com.songhaozhi.mayday.mapper.custom;

import java.util.List;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年9月27日 下午4:16:50
*/
public interface TagMapperCustom {

	List<Integer> selectByarticleId(Integer id);

	void delete(List<Integer> tagList);

}
