package com.ada.foodclive.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Table(name = "users")
@Getter
@Setter
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

    @Transient
    private String passwordCheck;

    // 유저 건강 정보 저장 컴럼을 위해 만듬
    @Column(name = "health_status", length = 500) // 길이를 지정
    private String healthStatus; // 유저 건강 정보

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated; // 건강 정보 마지막 업데이트 시간

}
