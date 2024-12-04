package com.ada.foodclive.controller;

import com.ada.foodclive.model.Product;
import com.ada.foodclive.model.WishlistItem;
import com.ada.foodclive.model.WishlistType;
import com.ada.foodclive.service.ProductService;
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

    @GetMapping
    public String viewWishlist(@RequestParam Long userId,
                               @RequestParam(required = false, defaultValue = "DIET") WishlistType type,
                               Model model) {
        List<WishlistItem> items = wishlistService.getItemsByType(userId, type);
        List<Product> products = productService.getAllProducts(); // 모든 제품 가져오기

        model.addAttribute("wishlistItems", items);
        model.addAttribute("products", products); // 제품 리스트 추가
        model.addAttribute("userId", userId);
        model.addAttribute("type", type.name());
        return "wishlist";
    }


    // 찜 목록 추가
    @PostMapping("/add")
    public String addToWishlist(@RequestParam Long userId,
                                @RequestParam Long productId,
                                @RequestParam WishlistType type) {
        wishlistService.addItemToWishlist(userId, productId, type);
        return "redirect:/wishlist?userId=" + userId + "&type=" + type.name();
    }

    // 찜 목록 삭제
    @PostMapping("/remove/{itemId}")
    public String removeFromWishlist(@PathVariable Long itemId,
                                     @RequestParam Long userId,
                                     @RequestParam WishlistType type) {
        wishlistService.removeItemFromWishlist(itemId);
        return "redirect:/wishlist?userId=" + userId + "&type=" + type.name();
    }
}
