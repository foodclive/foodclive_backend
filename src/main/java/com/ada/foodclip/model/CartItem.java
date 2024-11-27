package com.ada.foodclip.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // User랑 연결

    @Column(name = "product_name", nullable = false)
    private String productName; // 제품명

    @Column(name = "detail", nullable = true) // 상세 설명 필드
    private String detail; // 상세 설명?

    @Column(name = "price", nullable = false)
    private double price; // 가격
}
