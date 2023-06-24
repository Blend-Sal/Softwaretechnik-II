package com.example.softwaretechnik2.repositories;

import com.example.softwaretechnik2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface for Role repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Find a role by its name
    Role findByName(String name);
}

