package com.ada.foodclive.repository;

import com.ada.foodclive.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    // Product 엔티티 관리 선언 예정
}
