package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
