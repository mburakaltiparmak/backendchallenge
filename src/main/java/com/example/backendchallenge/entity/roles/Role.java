package com.example.backendchallenge.entity.roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role",schema = "backendchallenge")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "name")
    private Name name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "code")
    private Code code;

    @Column(name = "authority")
    private String authority;


    @Override
    public String getAuthority() {
        return authority;
    }


}
