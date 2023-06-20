package com.example.softwaretechnik2.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

/**
 * Represents a role entity in the system.
 * Each role has a name and may be associated with multiple users.
 * This class is annotated as an entity, so it is mapped to a table in the database.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length  = 55)
    private String name;

    @ManyToMany(mappedBy="roles")
    private List<User> users;
}
