package com.ada.foodclive.service;

import com.ada.foodclive.model.User;
import com.ada.foodclive.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;

    public Long save(User user) {
        return userRepo.save(user).getId();
    }

    public boolean isPhoneNumExists(String phoneNum) {
        return userRepo.findByPhoneNum(phoneNum).isPresent();
    }

    public boolean isUsernameExists(String username) {
        return userRepo.findByUsername(username).isPresent();
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password).orElse(null);
    }

    // 추가된 메서드: userId로 User 객체 조회
    public User findById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ID: " + id));
    }
}
