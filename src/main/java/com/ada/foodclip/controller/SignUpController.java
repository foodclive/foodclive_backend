package com.ada.foodclip.controller;

import com.ada.foodclip.model.User;
import com.ada.foodclip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class SignUpController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signupPage() {
        return "signup"; // 회원가입 페이지 렌더링
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String phoneNum,
                         @RequestParam String password,
                         @RequestParam String passwordCheck,
                         Model model) {
        // 비밀번호 확인
        if (!password.equals(passwordCheck)) {
            model.addAttribute("error", "Passwords do not match");
            return "signup";
        }

        // 중복 확인
        if (userService.isUsernameExists(username)) {
            model.addAttribute("error", "Username is already taken");
            return "signup";
        }

        if (userService.isPhoneNumExists(phoneNum)) {
            model.addAttribute("error", "Phone number is already registered");
            return "signup";
        }

        // User 객체 생성 및 저장
        User user = User.builder()
                .username(username)
                .phoneNum(phoneNum)
                .password(password) // 암호화 없이 저장 (임시)
                .build();

        userService.save(user); // UserService 호출하여 저장

        return "redirect:/auth/login"; // 회원가입 완료 후 로그인 페이지로 이동
    }
}
