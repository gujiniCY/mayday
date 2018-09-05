package com.songhaozhi.mayday.mapper;

import com.songhaozhi.mayday.model.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User getByNameAndPwd(@Param(value = "name") String name,@Param(value = "pwd") String pwd);
}