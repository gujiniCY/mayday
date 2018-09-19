package com.songhaozhi.mayday.mapper.custom;

import org.apache.ibatis.annotations.Param;

import com.songhaozhi.mayday.model.domain.User;
public interface UserMapperCustom {
    User getByNameAndPwd(@Param(value = "name") String name,@Param(value = "pwd") String pwd);

	void updateDatum(User user);
}