package com.api.spring.prueba.repository.security;

import com.api.spring.prueba.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String customer);
}
