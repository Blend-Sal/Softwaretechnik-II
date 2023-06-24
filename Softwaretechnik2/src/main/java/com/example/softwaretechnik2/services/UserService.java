package com.example.softwaretechnik2.services;

import com.example.softwaretechnik2.model.Role;
import com.example.softwaretechnik2.model.User;
import com.example.softwaretechnik2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        checkRole(user);
        userRepository.save(user);
    }


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    private void checkRole(User user) {
        if(user.getEmail().contains("@asta-shop")){
            user.getRoles().add(Role.USER);
        } else {
            user.getRoles().add(Role.EMPLOYEE);
        }
    }
}
