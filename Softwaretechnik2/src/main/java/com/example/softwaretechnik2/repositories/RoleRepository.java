package com.example.softwaretechnik2.repositories;

import com.example.softwaretechnik2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
