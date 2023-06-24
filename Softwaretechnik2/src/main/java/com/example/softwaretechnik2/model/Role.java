package com.example.softwaretechnik2.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

/**
 * Represents a role entity in the system.
 * Each role has a name and may be associated with multiple users.
 * This class is annotated as an entity, so it is mapped to a table in the database.
 */
public enum Role {
    USER("User"),
    EMPLOYEE("Employee");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
