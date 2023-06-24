package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.Role;
import com.example.softwaretechnik2.model.User;
import com.example.softwaretechnik2.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import javax.transaction.Transactional;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setFirstName("Aiman");
        user.setLastName("Alali");
        user.setEmail("aiman.alali@example.com");
        user.setPassword("password123");
        user.setConfirmedPassword("password123");
        user.getRoles().add(Role.USER);

        userRepository.save(user);
    }

    @Test
    void testFindByEmail() {
        Optional<User> foundUser = userRepository.findByEmail("aiman.alali@example.com");

        assertTrue(foundUser.isPresent());
        assertEquals(user.getEmail(), foundUser.get().getEmail());
    }

    @Test
    void testNonExistentEmail() {
        Optional<User> foundUser = userRepository.findByEmail("notfound@example.com");

        assertFalse(foundUser.isPresent());
    }

    @Test
    @Transactional
    void testSaveAndFindById() {
        User newUser = new User();
        newUser.setFirstName("Kawthar");
        newUser.setLastName("Alshaaer");
        newUser.setEmail("Kawthar.alshaaer@stud.th-luebeck.de");
        newUser.setPassword("password123");
        newUser.setConfirmedPassword("password123");

        User savedUser = userRepository.save(newUser);
        Optional<User> foundUser = userRepository.findById(savedUser.getId());

        assertTrue(foundUser.isPresent());
        assertEquals("Kawthar", foundUser.get().getFirstName());
    }

    @Test
    @Transactional
    void testUpdateUser() {
        Optional<User> foundUser = userRepository.findByEmail("aiman.alali@example.com");
        assertTrue(foundUser.isPresent());

        User userToUpdate = foundUser.get();
        userToUpdate.setFirstName("test");
        userRepository.save(userToUpdate);

        Optional<User> updatedUser = userRepository.findById(userToUpdate.getId());
        assertTrue(updatedUser.isPresent());
        assertEquals("test", updatedUser.get().getFirstName());
    }

    @Test
    void testDeleteUser() {
        Optional<User> foundUser = userRepository.findByEmail("aiman.alali@example.com");
        assertTrue(foundUser.isPresent());

        userRepository.delete(foundUser.get());

        Optional<User> deletedUser = userRepository.findById(foundUser.get().getId());
        assertFalse(deletedUser.isPresent());
    }
}
