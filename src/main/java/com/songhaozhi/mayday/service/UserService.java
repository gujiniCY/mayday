package com.songhaozhi.mayday.service;

import java.util.Date;

import com.songhaozhi.mayday.model.domain.User;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年8月27日 上午11:14:15
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
	User getByNameAndPwd(String name, String pwd);

	/**
	 * 修改用户资料
	 * 
	 * @param user
	 */
	void updateDatum(User user);

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
	User findByUserIdAndUserPwd(Integer userId, String formerlyPwd);

	/**
	 * 修改最后登录时间
	 * 
	 * @param date
	 * @param userId 
	 */
	void updateLoginLastTime(Date date, Integer userId);
	/**
	 * 修改用户状态为正常
	 * @param userId
	 */
	void updateUserNormal(Integer userId);
	/**
	 * 更新登录失败次数
	 * @return 
	 */
	Integer updateError();
	/**
	 * 禁止登录
	 * @param enable
	 */
	void updateLoginEnable(String enable);
}
