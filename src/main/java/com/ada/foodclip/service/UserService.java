package com.ada.foodclip.service;

import com.ada.foodclip.model.User;
import com.ada.foodclip.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;

    public Long save(User dto) {
        return userRepo.save(User.builder()
                .username(dto.getUsername()) // 유저명 가저와 설정
                .phoneNum(dto.getPhoneNum()) // phoneNum을 dto에서 가져와 설정
                .password(dto.getPassword()) // 비밀번호를 암호화 없이 그대로 저장
                .build()).getId();
    }
}
// 임시로 암호화 안함.
