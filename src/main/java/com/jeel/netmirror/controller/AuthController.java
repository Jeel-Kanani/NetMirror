package com.jeel.netmirror.controller;

import com.jeel.netmirror.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import com.jeel.netmirror.model.User;
import com.jeel.netmirror.dto.RegisterRequest;
import com.jeel.netmirror.dto.LoginRequest;
import com.jeel.netmirror.dto.LoginResponse;
import com.jeel.netmirror.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/auth/register")
    public User registerUser(
            @RequestBody RegisterRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return userService.registerUser(user);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {

        User user = userService.getUserByEmail(
                request.getEmail());

        if(user == null){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("User not found");
        }

        if(!userService.verifyPassword(
                request.getPassword(),
                user.getPassword())) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
