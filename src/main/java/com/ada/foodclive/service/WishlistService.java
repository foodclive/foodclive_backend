package com.ada.foodclive.service;

import com.ada.foodclive.model.Product;
import com.ada.foodclive.model.User;
import com.ada.foodclive.model.WishlistItem;
import com.ada.foodclive.model.WishlistType;
import com.ada.foodclive.repository.WishlistRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class WishlistService {
    private final WishlistRepo wishlistRepo;

    // 타입별 기본 해시태그 설정
    private static final Map<WishlistType, String> DEFAULT_HASHTAGS = new HashMap<>() {{
        put(WishlistType.DIET, "식단추천, 건강식");
        put(WishlistType.RECIPE, "레시피, 요리법");
        put(WishlistType.PRODUCT, "상품, 쇼핑");
        put(WishlistType.MARKET, "마켓, 할인정보");
    }};

    // 찜 목록 추가
    public WishlistItem addItemToWishlist(Long userId, Long productId, WishlistType wishlistType) {
        String hashtags = DEFAULT_HASHTAGS.get(wishlistType); // 타입별 해시태그 가져오기

        WishlistItem item = WishlistItem.builder()
                .user(User.builder().id(userId).build())
                .product(Product.builder().id(productId).build())
                .wishlistType(wishlistType)
                .hashtags(hashtags)
                .build();
        return wishlistRepo.save(item);
    }

    // 타입별 찜 목록 조회
    public List<WishlistItem> getItemsByType(Long userId, WishlistType wishlistType) {
        return wishlistRepo.findByUserIdAndWishlistType(userId, wishlistType);
    }

    // 찜 목록 삭제
    public void removeItemFromWishlist(Long itemId) {
        wishlistRepo.deleteById(itemId);
    }
}
