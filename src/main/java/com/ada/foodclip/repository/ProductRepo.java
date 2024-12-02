package com.ada.foodclip.repository;

import com.ada.foodclip.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
