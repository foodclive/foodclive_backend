package com.ada.foodclive.controller;

import com.ada.foodclive.model.Product;
import com.ada.foodclive.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    // 모든 제품 조회
    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list"; // 제품 리스트를 보여줄 HTML 페이지
    }

    // 제품 추가 페이지
    @GetMapping("/add")
    public String addProductPage() {
        return "product-add"; // 제품 추가 HTML 페이지
    }

    // 제품 추가 처리
    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam double price) {
        Product product = Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
        productService.addProduct(product);
        return "redirect:/products";
    }
}
