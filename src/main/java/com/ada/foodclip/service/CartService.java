package com.ada.foodclip.service;

import com.ada.foodclip.model.CartItem;
import com.ada.foodclip.model.Product;
import com.ada.foodclip.model.User;
import com.ada.foodclip.repository.CartItemRepo;
import com.ada.foodclip.repository.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartItemRepo cartItemRepo;
    private final ProductRepo productRepo;

    public CartItem addItemToCart(Long userId, Long productId, int quantity) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));
        CartItem item = CartItem.builder()
                .user(User.builder().id(userId).build())
                .product(product)
                .quantity(quantity)
                .build();
        return cartItemRepo.save(item);
    }

    public List<CartItem> getCartItems(Long userId) {
        return cartItemRepo.findByUserId(userId); // 특정 사용자의 장바구니 조회
    }

    @Transactional
    public void removeItemFromCart(Long itemId) {
        cartItemRepo.deleteById(itemId); // 장바구니에서 아이템 삭제
    }
}