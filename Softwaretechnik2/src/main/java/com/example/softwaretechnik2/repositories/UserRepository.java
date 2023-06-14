package com.example.softwaretechnik2.repositories;

import com.example.softwaretechnik2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

// Interface for User repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by their email address
    User findByEmail(@Param("email") String email);

}

