package com.ada.foodclip.service;

import com.ada.foodclip.model.Product;
import com.ada.foodclip.model.User;
import com.ada.foodclip.model.WishlistItem;
import com.ada.foodclip.repository.ProductRepo;
import com.ada.foodclip.repository.WishlistRepo;
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
        return wishlistRepo.findByUserId(userId);
    }

    public void removeItemFromWishlist(Long itemId) {
        wishlistRepo.deleteById(itemId);
    }
}
