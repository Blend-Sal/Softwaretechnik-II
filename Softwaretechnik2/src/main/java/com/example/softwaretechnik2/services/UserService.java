package com.example.softwaretechnik2.services;

import com.example.softwaretechnik2.model.Role;
import com.example.softwaretechnik2.model.User;
import com.example.softwaretechnik2.repositories.RoleRepository;
import com.example.softwaretechnik2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    // Autowired UserRepository for accessing user data
    @Autowired
    private UserRepository userRepository;

    // Autowired RoleRepository for accessing role data
    @Autowired
    private RoleRepository roleRepository;

    // Autowired PasswordEncoder for encoding user passwords
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Save a user to the repository after encoding the password and setting the appropriate role
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = checkRole(user);
        user.setRoles(List.of(role));
        userRepository.save(user);
    }

    // Find a user by their email address
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Find all users in the repository
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Check the user's role based on their email address and save the role to the repository
    private Role checkRole(User user) {
        Role role = new Role();
        if (user.getEmail().contains("@asta-shop")) {
            role.setName("ROLE_EMPLOYEE");
        } else {
            role.setName("ROLE_CLIENT");
        }
        return roleRepository.save(role);
    }
}


