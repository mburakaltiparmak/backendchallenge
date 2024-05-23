package com.example.backendchallenge.controller;

import com.example.backendchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //post işlemi yazılacak. validation,exception,exception response ve global exception handler yazılması gerekiyor.
/*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody UserDto userDto){
        return
    }
*/

}
