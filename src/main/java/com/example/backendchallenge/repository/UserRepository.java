package com.example.backendchallenge.repository;

import com.example.backendchallenge.entity.application_user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser,Long> {

    @Query(value = "SELECT u FROM ApplicationUser u WHERE u.email=:email")
    Optional<ApplicationUser> findUserByEmail(String email);

    //
    @Query(value = "INSERT INTO ApplicationUser (fullName, email, password, role) VALUES (:fullName, :email, :password, :role)", nativeQuery = true)
    void register(@Param("fullName") String fullName, @Param("email") String email, @Param("password") String password, @Param("role") String role);
    //





}
