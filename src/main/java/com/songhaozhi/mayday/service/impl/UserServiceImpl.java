package com.songhaozhi.mayday.service.impl;
/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年8月27日 上午11:14:35
*/

import com.songhaozhi.mayday.mapper.UserMapper;
import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByNameAndPwd(String name, String pwd) {
        return userMapper.getByNameAndPwd(name,pwd);
    }

}
