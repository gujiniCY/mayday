package com.songhaozhi.mayday.mapper.custom;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;

import com.songhaozhi.mayday.model.domain.Link;

/**
 * 
 * @author songhaozhi
 *
 */
public interface LinkMapperCustom {
	/**
	 * 修改
	 * @param linkId
	 * @return
	 */
	Optional<Link> findByLindId(@Param(value="linkId") int linkId);
	
	
	
}