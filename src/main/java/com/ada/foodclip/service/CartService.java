package com.ada.foodclip.service;

import com.ada.foodclip.model.CartItem;
import com.ada.foodclip.repository.CartItemRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartItemRepo cartItemRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public CartItem addItemToCart(CartItem item) {
        return cartItemRepo.save(item); // 장바구니에 추가
    }

    public List<CartItem> getCartItems(Long userId) {
        return cartItemRepo.findByUserId(userId); // 특정 사용자의 장바구니 조회
    }

    @Transactional
    public void removeItemFromCart(Long itemId) {
        cartItemRepo.deleteById(itemId); // 장바구니에서 아이템 삭제
        resetAutoIncrementIfEmpty();    // 장바구니가 비었으면 AUTO_INCREMENT 초기화
    }

    @Transactional
    public void resetAutoIncrementIfEmpty() {
        // 테이블이 비었는지 확인
        long count = cartItemRepo.count();
        if (count == 0) {
            // AUTO_INCREMENT 초기화 (MySQL용 쿼리)
            entityManager.createNativeQuery("ALTER TABLE cart_items AUTO_INCREMENT = 1").executeUpdate();
        }
    }
}
