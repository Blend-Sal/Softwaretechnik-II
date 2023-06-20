package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.Role;
import com.example.softwaretechnik2.model.User;
import com.example.softwaretechnik2.repositories.RoleRepository;
import com.example.softwaretechnik2.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RoleTest {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private Role role;

    @BeforeEach
    void setUp() {
        // Create a new Role
        role = new Role();
        role.setName("ROLE_USER");

        // Save the Role so that it's managed by Hibernate
        role = roleRepository.save(role);

        // Create a new User
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
        user.setConfirmedPassword("password123");

        // Save the User so that it's managed by Hibernate
        user = userRepository.save(user);

        // Now that both Role and User are managed by Hibernate, establish the relationship
        user.setRoles(Collections.singletonList(role));
        role.setUsers(Collections.singletonList(user));

        // Save both entities again to persist the relationship
        userRepository.save(user);
        roleRepository.save(role);
    }



    @Test
    void testFindRoleByName() {
        Optional<Role> foundRole = roleRepository.findByName("ROLE_USER");

        assertTrue(foundRole.isPresent());
        assertEquals(role.getName(), foundRole.get().getName());
    }

    @Test
    void testNonExistentRoleName() {
        Optional<Role> foundRole = roleRepository.findByName("ROLE_NON_EXISTENT");

        assertFalse(foundRole.isPresent());
    }

    @Test
    void testSaveAndFindById() {
        Role newRole = new Role();
        newRole.setName("ROLE_ADMIN");

        Role savedRole = roleRepository.save(newRole);
        Optional<Role> foundRole = roleRepository.findById(savedRole.getId());

        assertTrue(foundRole.isPresent());
        assertEquals("ROLE_ADMIN", foundRole.get().getName());
    }

    @Test
    void testUpdateRole() {
        Optional<Role> foundRole = roleRepository.findByName("ROLE_USER");
        assertTrue(foundRole.isPresent());

        Role roleToUpdate = foundRole.get();
        roleToUpdate.setName("ROLE_UPDATED");
        roleRepository.save(roleToUpdate);

        Optional<Role> updatedRole = roleRepository.findById(roleToUpdate.getId());
        assertTrue(updatedRole.isPresent());
        assertEquals("ROLE_UPDATED", updatedRole.get().getName());
    }

    @Test
    void testDeleteRole() {
        Optional<Role> foundRole = roleRepository.findByName("ROLE_USER");
        assertTrue(foundRole.isPresent());

        roleRepository.delete(foundRole.get());

        Optional<Role> deletedRole = roleRepository.findById(foundRole.get().getId());
        assertFalse(deletedRole.isPresent());
    }
}
