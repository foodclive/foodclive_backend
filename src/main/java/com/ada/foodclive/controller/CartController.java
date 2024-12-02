package com.ada.foodclive.controller;

import com.ada.foodclive.model.CartItem;
import com.ada.foodclive.model.Product;
import com.ada.foodclive.model.User;
import com.ada.foodclive.service.CartService;
import com.ada.foodclive.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ProductService productService;

    @GetMapping
    public String getCartPage(@RequestParam("userId") Long userId, Model model) {
        List<CartItem> cartItems = cartService.getCartItems(userId);
        List<Product> products = productService.getAllProducts(); // 모든 제품 가져오기
        model.addAttribute("cartItems", cartItems); // 장바구니 아이템
        model.addAttribute("products", products); // 제품 목록 추가
        model.addAttribute("userId", userId);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("userId") Long userId,
                            @RequestParam("productId") Long productId,
                            @RequestParam("quantity") int quantity) {
        cartService.addItemToCart(userId, productId, quantity);
        return "redirect:/cart?userId=" + userId;
    }


    @PostMapping("/remove")
    public String removeFromCart(@RequestParam("itemId") Long itemId,
                                 @RequestParam("userId") Long userId) {
        cartService.removeItemFromCart(itemId);
        return "redirect:/cart?userId=" + userId;
    }
}