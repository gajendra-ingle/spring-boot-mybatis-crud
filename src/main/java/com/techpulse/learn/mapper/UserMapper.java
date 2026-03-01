package com.techpulse.learn.mapper;

import com.techpulse.learn.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Long id);

    List<User> findAll();

    void insertUser(User user);

    int deleteUser(Long id);
}
