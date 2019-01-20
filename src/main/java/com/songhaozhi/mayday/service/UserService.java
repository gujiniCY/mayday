package com.songhaozhi.mayday.service;

import java.util.Date;

import com.songhaozhi.mayday.model.domain.User;

/**
 * @author : 宋浩志
 * @createDate : 2018年8月27日
 */
public interface UserService {
	/**
	 * 根据用户名和密码获取用户信息
	 * 
	 * @param name
	 *            用户名
	 * @param pwd
	 *            用户密码
	 * @return
	 */
	User getByNameAndPwd(String name, String pwd) throws Exception;

	/**
	 * 修改用户资料
	 * 
	 * @param user
	 */
	void updateDatum(User user) throws Exception;

	/**
	 * 用户id获取用户信息
	 * 
	 * @return
	 */
	User findUser();

	/**
	 * 查询原密码是否存在
	 * 
	 * @param userId
	 *            用户id
	 * @param formerlyPwd
	 *            原密码
	 * @return
	 */
	User findByUserIdAndUserPwd(Integer userId, String formerlyPwd) throws Exception;

	/**
	 * 修改最后登录时间
	 * 
	 * @param date
	 * @param userId
	 */
	void updateLoginLastTime(Date date, Integer userId) throws Exception;

	/**
	 * 修改用户状态为正常
	 * 
	 * @param userId
	 */
	void updateUserNormal(Integer userId) throws Exception;

	/**
	 * 更新登录失败次数
	 * 
	 * @return
	 */
	Integer updateError() throws Exception;

	/**
	 * 禁止登录
	 * 
	 * @param enable 状态
	 * @param error 错误次数
	 */
	void updateLoginEnable(String enable, Integer error) throws Exception;
	/**
	 * 保存用户
	 * @param user
	 */
	void save(User user);
}
