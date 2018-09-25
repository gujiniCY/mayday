package com.songhaozhi.mayday.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.songhaozhi.mayday.model.domain.User;

/**
 * 
 * @author songhaozhi
 *
 */
public interface UserMapperCustom {
	/**
	 * 根据用户名和密码查询用户
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
	 * 
	 * @return
	 */
	List<User> findUser();

	/**
	 * 查询原密码是否存在
	 * 
	 * @param userId
	 *            用户id
	 * @param formerlyPwd
	 *            原密码
	 * @return
	 */
	User findByUserIdAndUserPwd(@Param(value = "userId") Integer userId,
			@Param(value = "formerlyPwd") String formerlyPwd);

}