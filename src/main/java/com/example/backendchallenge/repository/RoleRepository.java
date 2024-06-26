package com.example.backendchallenge.repository;

import com.example.backendchallenge.entity.roles.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role,Long>{

    @Query(value = "SELECT * FROM backendchallenge.role_graph", nativeQuery = true)
    List<Role> getRoles();

    @Query(value = "SELECT * FROM backendchallenge.role_graph WHERE role_graph.role = :role", nativeQuery = true)
    Optional<Role> findByAuthority(@Param("role") String role);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO backendchallenge.role_graph(role) VALUES (:role)", nativeQuery = true)
    void createRole(@Param("role") String role);

}
