package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.domain.Theme;
import com.songhaozhi.mayday.model.domain.ThemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThemeMapper {
	long countByExample(ThemeExample example);

	int deleteByExample(ThemeExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Theme record);

	int insertSelective(Theme record);

	List<Theme> selectByExample(ThemeExample example);

	Theme selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Theme record, @Param("example") ThemeExample example);

	int updateByExample(@Param("record") Theme record, @Param("example") ThemeExample example);

	int updateByPrimaryKeySelective(Theme record);

	int updateByPrimaryKey(Theme record);
}