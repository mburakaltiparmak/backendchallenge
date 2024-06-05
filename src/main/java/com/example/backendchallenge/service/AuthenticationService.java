package com.example.backendchallenge.service;

import com.example.backendchallenge.entity.application_user.ApplicationUser;
import com.example.backendchallenge.entity.roles.Role;
import com.example.backendchallenge.repository.RoleRepository;
import com.example.backendchallenge.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthenticationService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ApplicationUser register(String fullName, String email, String password, String role) {
        String encodedPassword = passwordEncoder.encode(password);

        Role userRole = roleRepository.findByAuthority(role)
                .orElseGet(() -> {
                    roleRepository.createRole(role);
                    return roleRepository.findByAuthority(role).orElseThrow(() -> new RuntimeException("Role creation failed: " + role));
                });

        List<Role> roles = new ArrayList<>();
        roles.add(userRole);

        ApplicationUser user = new ApplicationUser();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setRoles(roles);

        return userRepository.save(user);
    }
    public Role createRole(String role){
        Role createdRole = roleRepository.findByAuthority(role)
                /* .orElseThrow(() -> new RuntimeException("Role not found: " + role));*/
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setRole(role);

                    return roleRepository.save(newRole);
                });
        List<Role> roles = new ArrayList<>();
        roles.add(createdRole);
        Role role1 = new Role();
        role1.setRole(roles.toString());
        return roleRepository.save(role1);
    }
}

