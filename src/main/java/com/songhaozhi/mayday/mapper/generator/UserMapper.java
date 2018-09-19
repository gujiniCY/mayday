package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.domain.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}