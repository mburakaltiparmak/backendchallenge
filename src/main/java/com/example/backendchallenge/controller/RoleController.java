package com.example.backendchallenge.controller;

import com.example.backendchallenge.dto.RoleCreator;
import com.example.backendchallenge.dto.RoleResponse;
import com.example.backendchallenge.entity.roles.Role;
import com.example.backendchallenge.repository.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @GetMapping
    public List<Role> getRoles(){
        return roleRepository.getRoles();
    }
    @PostMapping("/create")
    public RoleResponse createRole(@RequestBody RoleCreator roleCreator) {
        roleRepository.createRole(roleCreator.getRole());
        Optional<Role> createdRole = roleRepository.findByAuthority(roleCreator.getRole());
        return createdRole.map(role -> new RoleResponse(role.getRole(),role.getRole() + " " + "rolü başarıyla eklendi."))
                .orElseThrow(() -> new RuntimeException("Role creation failed"));
    }

}
