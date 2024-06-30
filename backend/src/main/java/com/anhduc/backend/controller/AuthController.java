package com.anhduc.backend.controller;

import com.anhduc.backend.dto.ResponseDto;
import com.anhduc.backend.dto.UserRegistrationDto;
import com.anhduc.backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseDto<Void> register(@Valid @RequestBody UserRegistrationDto userRegistrationDto, HttpServletRequest request) {
        String appUrl = request.getContextPath();
        userService.registerUser(userRegistrationDto, appUrl);
        return ResponseDto.<Void>builder()
                .status(HttpStatus.CREATED)
                .message("Register account successfully")
                .build();
    }
}
