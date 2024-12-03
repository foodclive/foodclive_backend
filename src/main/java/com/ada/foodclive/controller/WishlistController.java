package com.ada.foodclive.controller;

import com.ada.foodclive.model.Product;
import com.ada.foodclive.model.User;
import com.ada.foodclive.model.WishlistItem;
import com.ada.foodclive.service.ProductService;
import com.ada.foodclive.service.UserService;
import com.ada.foodclive.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;
    private final ProductService productService;
    private final UserService userService;

    @GetMapping
    public String viewWishlist(@RequestParam Long userId, Model model) {
        List<WishlistItem> wishlistItems = wishlistService.getWishlistItems(userId); // 찜 목록
        List<Product> products = productService.getAllProducts(); // 모든 제품
        model.addAttribute("wishlistItems", wishlistItems);
        model.addAttribute("products", products);
        model.addAttribute("userId", userId); // 사용자 ID 전달
        return "wishlist";
    }


    @PostMapping("/add")
    public String addToWishlist(@RequestParam("userId") Long userId,
                                @RequestParam("productId") Long productId) {
        wishlistService.addItemToWishlist(userId, productId);
        return "redirect:/wishlist?userId=" + userId;
    }


    @PostMapping("/remove/{itemId}")
    public String removeFromWishlist(@PathVariable Long itemId, @RequestParam Long userId) {
        wishlistService.removeItemFromWishlist(itemId);
        return "redirect:/wishlist?userId=" + userId;
    }
}
