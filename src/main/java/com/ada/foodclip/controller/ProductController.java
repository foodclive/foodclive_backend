package com.ada.foodclip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/auth/product")
    public String product(){
        return "product";
    }
}
