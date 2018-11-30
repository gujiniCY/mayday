package com.songhaozhi.mayday.mapper.custom;

import java.util.List;

/**
 * 
 * @author songhaozhi
 *
 */
public interface CategoryMapperCustom {

	List<Integer> selectByarticleId(Integer id);

	void delete(List<Integer> cateList);
	
}