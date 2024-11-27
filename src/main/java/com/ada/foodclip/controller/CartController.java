package com.ada.foodclip.controller;

import com.ada.foodclip.model.CartItem;
import com.ada.foodclip.model.User;
import com.ada.foodclip.service.CartService;
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

    @GetMapping
    public String getCartPage(@RequestParam("userId") Long userId, Model model) {
        List<CartItem> cartItems = cartService.getCartItems(userId);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("userId", userId);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("userId") Long userId,
                            @RequestParam("productName") String productName,
                            @RequestParam("detail") String detail,
                            @RequestParam("price") double price) {
        CartItem item = CartItem.builder()
                .user(User.builder().id(userId).build())
                .productName(productName)
                .detail(detail)
                .price(price)
                .build();
        cartService.addItemToCart(item);
        return "redirect:/cart?userId=" + userId;
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam("itemId") Long itemId,
                                 @RequestParam("userId") Long userId) {
        cartService.removeItemFromCart(itemId);
        return "redirect:/cart?userId=" + userId;
    }
}
