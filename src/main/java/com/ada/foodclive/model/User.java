package com.ada.foodclip.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "phoneNum", nullable = false, unique = true)
    private String phoneNum;

    @Column(name = "password", nullable = false)
    private String password;

    @Transient // 데이터베이스에 저장되지 않도록 설정
    private String passwordCheck;
}
