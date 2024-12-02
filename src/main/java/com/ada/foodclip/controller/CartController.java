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
