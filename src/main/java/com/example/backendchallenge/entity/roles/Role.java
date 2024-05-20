package com.example.backendchallenge.entity.roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role",schema = "backendchallenge")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "name")
    private Name name;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "code")
    private Code code;
}