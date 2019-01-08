package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.domain.Log;
import com.songhaozhi.mayday.model.domain.LogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogMapper {
	long countByExample(LogExample example);

	int deleteByExample(LogExample example);

	int deleteByPrimaryKey(Integer logId);

	int insert(Log record);

	int insertSelective(Log record);

	List<Log> selectByExample(LogExample example);

	Log selectByPrimaryKey(Integer logId);

	int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

	int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

	int updateByPrimaryKeySelective(Log record);

	int updateByPrimaryKey(Log record);
}