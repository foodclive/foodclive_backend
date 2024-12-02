package com.ada.foodclive.repository;

import com.ada.foodclive.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepo extends JpaRepository<WishlistItem, Long> {
    List<WishlistItem> findByUserId(Long userId); // 특정 사용자의 찜 목록 검색
}
