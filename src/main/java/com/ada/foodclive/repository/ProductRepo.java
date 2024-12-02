package com.ada.foodclive.repository;

import com.ada.foodclive.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
