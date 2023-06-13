package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class RoleTest {

    @Test
    void roleTest() {
        Role role = new Role();
        String name = "Lukas";
        role.setName(name);
        assertEquals(name, role.getName());
    }

    @Test
    void idTest() {
        Role role = new Role();
        long id = 2;
        role.setId(id);
        assertEquals(id, role.getId());
    }

    @Test
    void nameLengthTest() {
        Role role = new Role();
        String name = "Ein sehr langer Rollenname, der maximal 55 Zeichen lang sein sollte";
        assertFalse("Die Namenslänge sollte kleiner oder gleich 55 sein", name.length() <= 55);
        role.setName(name);
        assertEquals(name, role.getName());
    }
}
