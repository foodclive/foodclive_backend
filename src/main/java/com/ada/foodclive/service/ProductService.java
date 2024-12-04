package com.ada.foodclive.service;

import com.ada.foodclive.model.Product;
import com.ada.foodclive.repository.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final JdbcTemplate jdbcTemplate; // SQL 실행을 위한 JdbcTemplate

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        // 관련된 wishlist_items 삭제
        jdbcTemplate.update("DELETE FROM wishlist_items WHERE product_id = ?", id);

        // 제품 삭제
        productRepo.deleteById(id);

        // AUTO_INCREMENT 및 ID 재정렬
        reorderIds();
    }

    private void reorderIds() {
        jdbcTemplate.execute("SET @count = 0");
        jdbcTemplate.execute("UPDATE products SET id = (@count := @count + 1)");
        jdbcTemplate.execute("ALTER TABLE products AUTO_INCREMENT = 1");
    }
}
