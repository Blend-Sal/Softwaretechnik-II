package com.example.softwaretechnik2.services;

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

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
