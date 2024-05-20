package com.example.backendchallenge.repository;

import com.example.backendchallenge.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
