package com.songhaozhi.mayday.service.impl;
/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年8月27日 上午11:14:35
*/

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
		return userMapperCustom.findUser();
	}

}
