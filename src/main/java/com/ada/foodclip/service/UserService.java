package com.ada.foodclip.service;

import com.ada.foodclip.model.User;
import com.ada.foodclip.repository.UserRepo;
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
}
