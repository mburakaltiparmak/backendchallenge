package com.example.backendchallenge.repository;

import com.example.backendchallenge.entity.roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role,Long>{

    @Query(value = "SELECT * FROM backendchallenge.role",nativeQuery = true)
    List<Role> getRoles();
    @Query(value = "SELECT r FROM Role r WHERE r.authority = : authority")
    Optional<Role> findByAuthority(String authority);

}
