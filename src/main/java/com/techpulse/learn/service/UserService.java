package com.techpulse.learn.service;

import com.techpulse.learn.entity.User;
import com.techpulse.learn.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;


    public User getUser(Long id) {
        return userMapper.findById(id);
    }


    public List<User> getAllUsers() {
        return userMapper.findAll();
    }


    public User createUser(User user) {
        userMapper.insertUser(user);
        return user;
    }


    public boolean deleteUser(Long id) {
        return userMapper.deleteUser(id) > 0;
    }

}
