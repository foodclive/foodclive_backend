package com.ada.foodclip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController
{
    @GetMapping("/auth/signup")
    public String signup(){
        return "signup";
    }
}
