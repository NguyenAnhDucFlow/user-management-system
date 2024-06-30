package com.anhduc.backend.entity;

import com.anhduc.backend.util.AuditAble;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends AuditAble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private String provider;

    private String providerId;

    private Boolean isActive = true;

    @Column(nullable = false, unique = true)
    private String email;

    private Boolean isEmailVerified  = false;


}
