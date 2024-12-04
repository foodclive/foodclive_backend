package com.ada.foodclive.repository;

import com.ada.foodclive.model.WishlistItem;
import com.ada.foodclive.model.WishlistType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepo extends JpaRepository<WishlistItem, Long> {
    List<WishlistItem> findByUserIdAndWishlistType(Long userId, WishlistType wishlistType);
}
