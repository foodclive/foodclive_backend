package com.ada.foodclip.controller;

import com.ada.foodclip.model.User;
import com.ada.foodclip.model.WishlistItem;
import com.ada.foodclip.service.UserService;
import com.ada.foodclip.service.WishlistService;
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
    private final UserService userService;

    @GetMapping
    public String viewWishlist(@RequestParam Long userId, Model model) {
        List<WishlistItem> wishlistItems = wishlistService.getWishlistItems(userId);
        model.addAttribute("wishlistItems", wishlistItems);
        model.addAttribute("userId", userId);
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
