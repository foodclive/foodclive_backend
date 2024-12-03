package com.ada.foodclive.controller;

import com.ada.foodclive.model.User;
import com.ada.foodclive.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    // 특정 유저 정보 조회
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok(user);
    }

    // 유저의 건강 상태 업데이트
    @PostMapping("/{userId}/health")
    public ResponseEntity<String> updateHealthStatus(
            @PathVariable Long userId,
            @RequestBody String healthStatus) {
        userService.updateHealthStatus(userId, healthStatus);
        return ResponseEntity.ok("Health status updated successfully");
    }

    // 전체 유저 리스트 조회 (선택 사항)
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    // 새로운 유저 등록 (선택 사항)
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok("User created successfully");
    }
}
