package com.techpulse.learn.service;

import com.techpulse.learn.dto.ApiResponse;
import com.techpulse.learn.entity.User;
import com.techpulse.learn.exception.ResourceNotFoundException;
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

    public List<User> searchUsersByName(String name) {
        return userMapper.searchUsersByName(name);
    }

    public ApiResponse<Void> softDeleteUser(Long id) {
        if (id == null || id <= 0) {
            return new ApiResponse<>(false, "Invalid user ID", null);
        }

        User user = userMapper.findById(id);
        if (user == null) {
            return new ApiResponse<>(false, "User not found", null);
        }

        if (user.getIsDeleted() != null && user.getIsDeleted() == 1) {
            return new ApiResponse<>(false, "User already deleted", null);
        }

        return userMapper.softDeleteUser(id) > 0 ?
                new ApiResponse<>(true, "User deleted successfully", null) :
                new ApiResponse<>(false, "Failed to delete user", null);
    }

    public List<User> getAllActiveUsers() {
        List<User> users = userMapper.findAllActiveUsers();
        if (users == null || users.isEmpty()) {
            throw new ResourceNotFoundException("No active users found");
        }
        return users;
    }

    public long countUsers() {
        return userMapper.countUsers();
    }
}
