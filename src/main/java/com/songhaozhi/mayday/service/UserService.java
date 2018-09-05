package com.songhaozhi.mayday.service;

import com.songhaozhi.mayday.model.domain.User;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年8月27日 上午11:14:15
*/
public interface UserService {
        public User getByNameAndPwd(String name,String pwd);
}
