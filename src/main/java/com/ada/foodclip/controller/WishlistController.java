package com.ada.foodclip.controller;

import com.ada.foodclip.model.WishlistItem;
import com.ada.foodclip.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    @PostMapping("/add")
    public WishlistItem addToWishlist(@RequestBody WishlistItem item) {
        return wishlistService.addItemToWishlist(item); // 찜 목록에 추가
    }

    @GetMapping("/{userId}")
    public List<WishlistItem> getWishlistItems(@PathVariable Long userId) {
        return wishlistService.getWishlistItems(userId); // 특정 사용자의 찜 목록 조회
    }

    @DeleteMapping("/remove/{itemId}")
    public void removeFromWishlist(@PathVariable Long itemId) {
        wishlistService.removeItemFromWishlist(itemId); // 찜 목록에서 삭제
    }
}
