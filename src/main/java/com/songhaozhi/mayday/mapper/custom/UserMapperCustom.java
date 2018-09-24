package com.songhaozhi.mayday.mapper.custom;

import org.apache.ibatis.annotations.Param;

import com.songhaozhi.mayday.model.domain.User;

/**
 * 
 * @author songhaozhi
 *
 */
public interface UserMapperCustom {
	/**
	 * 
	 * @param name
	 *            用户名
	 * @param pwd
	 *            用户密码
	 * @return 根据用户名和密码获取用户信息
	 */
	User getByNameAndPwd(@Param(value = "name") String name, @Param(value = "pwd") String pwd);

	/**
	 * 修改用户资料
	 * 
	 * @param user
	 */
	void updateDatum(User user);
	/**
	 * 用户资料查询
	 * @return
	 */
	User findUser();
}