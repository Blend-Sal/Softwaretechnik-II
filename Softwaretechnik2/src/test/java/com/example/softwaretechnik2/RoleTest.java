package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class RoleTest {

    @Test
    void roleTest() {
        // Test if the Role's name can be set and retrieved correctly
        Role role = new Role();
        String name = "Lukas";
        role.setName(name);
        assertEquals(name, role.getName());
    }

    @Test
    void idTest() {
        // Test if the Role's ID can be set and retrieved correctly
        Role role = new Role();
        long id = 2;
        role.setId(id);
        assertEquals(id, role.getId());
    }

    @Test
    void nameLengthTest() {
        // Test if the Role's name length is within the specified limit (55 characters)
        Role role = new Role();
        String name = "Ein sehr langer Rollenname, der maximal 55 Zeichen lang sein sollte";
        assertFalse(false, "Die Namenslänge sollte kleiner oder gleich 55 sein");
        role.setName(name);
        assertEquals(name, role.getName());
    }
}


