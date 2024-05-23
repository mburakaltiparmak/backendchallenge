package com.example.backendchallenge.repository;

import com.example.backendchallenge.entity.application_user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser,Long> {

    @Query(value = "SELECT u FROM ApplicationUser u WHERE u.email=:email")
    Optional<ApplicationUser> findUserByEmail(String email);




}
