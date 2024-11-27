package com.ada.foodclip.repository;

import com.ada.foodclip.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId); // 특정 사용자의 장바구니 아이템 검색
}
