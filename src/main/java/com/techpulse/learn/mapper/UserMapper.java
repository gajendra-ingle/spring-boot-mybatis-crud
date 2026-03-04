package com.techpulse.learn.mapper;

import com.techpulse.learn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Long id);

    List<User> findAll();

    void insertUser(User user);

    int deleteUser(Long id);

    List<User> searchUsersByName(@Param("name") String name);

    int softDeleteUser(Long id);

    List<User> findAllActiveUsers();

    long countUsers();

    // User findByIdIncludingDeleted(Long id);

}
