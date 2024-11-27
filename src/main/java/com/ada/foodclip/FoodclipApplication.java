package com.ada.foodclip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodclipApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodclipApplication.class, args);
        System.out.println("Server Open");
        System.out.println("로그인 테스트 : http://localhost:8080/auth/login");
        System.out.println("회원가입 테스트 : http://localhost:8080/auth/signup");
        System.out.println("장바구니 테스트 : http://localhost:8080/cart?userId=1");
    }
}
