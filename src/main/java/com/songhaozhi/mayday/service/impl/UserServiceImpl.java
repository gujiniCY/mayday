package com.songhaozhi.mayday.service.impl;
/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年8月27日 上午11:14:35
*/

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhaozhi.mayday.mapper.custom.UserMapperCustom;
import com.songhaozhi.mayday.mapper.generator.UserMapper;
import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapperCustom userMapperCustom;
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getByNameAndPwd(String name, String pwd) {
		return userMapperCustom.getByNameAndPwd(name, pwd);
	}

	@Override
	public void updateDatum(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User findUser() {
		List<User> lists = userMapperCustom.findUser();
		if (lists != null && lists.size() > 0) {
			return lists.get(0);
		} else {
			return new User();
		}
	}

	@Override
	public User findByUserIdAndUserPwd(Integer userId, String formerlyPwd) {
		return userMapperCustom.findByUserIdAndUserPwd(userId, formerlyPwd);
	}

	@Override
	public void updateLoginLastTime(Date date, Integer userId) {
		User user = new User();
		user.setLoginLastTime(date);
		user.setUserId(userId);
		userMapper.updateByPrimaryKeySelective(user);

	}

	@Override
	public void updateUserNormal(Integer userId) {
		User user = new User();
		user.setLoginError(0);
		user.setLoginEnable("false");
		user.setUserId(userId);
		user.setLoginLastTime(new Date());
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public Integer updateError() {
		User user = this.findUser();
		user.setLoginError((user.getLoginError() == null ? 0 : user.getLoginError()) + 1);
		userMapper.updateByPrimaryKeySelective(user);
		return user.getLoginError();
	}

	@Override
	public void updateLoginEnable(String enable) {
		User user = this.findUser();
		user.setLoginEnable(enable);
		userMapper.updateByPrimaryKeySelective(user);
	}

}
