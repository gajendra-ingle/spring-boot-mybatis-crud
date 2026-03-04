package com.techpulse.learn.controller;

import com.techpulse.learn.dto.ApiResponse;
import com.techpulse.learn.entity.User;
import com.techpulse.learn.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        if (!isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User with id " + id + " not found.");
        }
        return ResponseEntity.ok("User with id " + id + " deleted successfully.");
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<ApiResponse<List<User>>> searchUsersByName(@PathVariable String name) {
        List<User> users = userService.searchUsersByName(name);
        boolean success = !users.isEmpty();
        String message = success ?
                "Users found successfully" :
                "No users found with name containing: " + name;

        return ResponseEntity.ok(new ApiResponse<>(success, message, users));
    }

    @DeleteMapping("/soft/{id}")
    public ResponseEntity<ApiResponse<Void>> softDelete(@PathVariable Long id) {
        ApiResponse<Void> response = userService.softDeleteUser(id);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<User>>> getActiveUsers() {
        List<User> users = userService.getAllActiveUsers();
        return ResponseEntity.ok(new ApiResponse<>(true, "Active users retrieved successfully", users));
    }

    @GetMapping("/count")
    public ResponseEntity<ApiResponse<Long>> countUsers() {
        long count = userService.countUsers();

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Total users count retrieved", count)
        );
    }

}
