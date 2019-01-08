package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.domain.Menu;
import com.songhaozhi.mayday.model.domain.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
	long countByExample(MenuExample example);

	int deleteByExample(MenuExample example);

	int deleteByPrimaryKey(Integer menuId);

	int insert(Menu record);

	int insertSelective(Menu record);

	List<Menu> selectByExample(MenuExample example);

	Menu selectByPrimaryKey(Integer menuId);

	int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

	int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

	int updateByPrimaryKeySelective(Menu record);

	int updateByPrimaryKey(Menu record);
}