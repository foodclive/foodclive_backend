package com.ada.foodclive.repository;

import com.ada.foodclive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> { // ID 타입 수정
    Optional<User> findByUsername(String username);
    Optional<User> findByPhoneNum(String phoneNum);
    Optional<User> findByUsernameAndPassword(String username, String password); // 로그인에 사용
}
