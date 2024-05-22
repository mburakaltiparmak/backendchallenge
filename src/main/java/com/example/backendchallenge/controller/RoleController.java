package com.example.backendchallenge.controller;

import com.example.backendchallenge.entity.roles.Role;
import com.example.backendchallenge.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @GetMapping
    public List<Role> getRoles(){
        return roleRepository.getRoles();
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
