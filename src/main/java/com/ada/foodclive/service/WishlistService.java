package com.ada.foodclive.service;

import com.ada.foodclive.model.Product;
import com.ada.foodclive.model.User;
import com.ada.foodclive.model.WishlistItem;
import com.ada.foodclive.repository.ProductRepo;
import com.ada.foodclive.repository.WishlistRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WishlistService {
    private final WishlistRepo wishlistRepo;
    private final ProductRepo productRepo;

    public WishlistItem addItemToWishlist(Long userId, Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));
        WishlistItem item = WishlistItem.builder()
                .user(User.builder().id(userId).build())
                .product(product)
                .build();
        return wishlistRepo.save(item);
    }

    public List<WishlistItem> getWishlistItems(Long userId) {
        return wishlistRepo.findByUserId(userId); // 찜 목록 검색
    }

    public void removeItemFromWishlist(Long itemId) {
        wishlistRepo.deleteById(itemId);
    }
}
