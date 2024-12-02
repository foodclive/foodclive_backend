package com.ada.foodclip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodcliveApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodcliveApplication.class, args);
        System.out.println("Server Open");
        System.out.println("로그인 테스트 : http://localhost:8080/auth/login");
        System.out.println("회원가입 테스트 : http://localhost:8080/auth/signup");
        System.out.println("장바구니 테스트 : http://localhost:8080/cart?userId=1");
        System.out.println("찜 목록 테스트 : http://localhost:8080/wishlist?userId=1");
    }
}
