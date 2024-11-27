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
public class LoginController {
    private final UserService userService;

    // 로그인 페이지 렌더링
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // login.html 렌더링
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findUserByUsernameAndPassword(username, password);
        if (user != null) {
            model.addAttribute("message", "Welcome, " + username + "!");
            return "welcome"; // 로그인 성공 페이지로 이동
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // 로그인 페이지로 다시 이동
        }
    }
}
