package com.ada.foodclip.repository;

import com.ada.foodclip.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    Optional<User> findByPhoneNum(String phoneNum);
    Optional<User> findByPassword(String password);
}
