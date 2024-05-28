package com.example.backendchallenge.controller;

import com.example.backendchallenge.dto.RegisterResponse;
import com.example.backendchallenge.dto.RegisterUser;
import com.example.backendchallenge.entity.application_user.ApplicationUser;
import com.example.backendchallenge.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


@PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterUser registerUser){
        ApplicationUser createdUser = authenticationService.register(registerUser.getFullName(), registerUser.getEmail(), registerUser.getPassword());
       return new RegisterResponse(createdUser.getFullName(), createdUser.getEmail(), "kayıt başarılı bir şekilde gerçekleşti.");
    }
}
