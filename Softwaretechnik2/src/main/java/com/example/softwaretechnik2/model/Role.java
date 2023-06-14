package com.example.softwaretechnik2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// The Role class represents a user role in the system
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role {

    // Fields with annotations for mapping to the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name field with unique constraint
    @Column(nullable = false, unique = true, length  = 55)
    private String name;

    // Many-to-many relationship with the User entity
    @ManyToMany(mappedBy="roles")
    private List<User> users;
}
