package com.ada.foodclip.service;

import com.ada.foodclip.model.WishlistItem;
import com.ada.foodclip.repository.WishlistRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WishlistService {
    private final WishlistRepo wishlistRepo;

    public WishlistItem addItemToWishlist(WishlistItem item) {
        return wishlistRepo.save(item); // 찜 목록에 추가
    }

    public List<WishlistItem> getWishlistItems(Long userId) {
        return wishlistRepo.findByUserId(userId); // 특정 사용자의 찜 목록 조회
    }

    public void removeItemFromWishlist(Long itemId) {
        wishlistRepo.deleteById(itemId); // 찜 목록에서 삭제
    }
}
