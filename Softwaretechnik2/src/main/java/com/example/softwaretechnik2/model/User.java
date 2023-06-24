package com.example.softwaretechnik2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

// The User class represents a user in the system
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    // Fields with annotations for mapping to the database
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    @Size(min=2, max=20)
    private String firstName;

    @Column(nullable = false)
    @Size(min=2, max=20)
    private String lastName;

    // Email field with validation constraints
    @Column(nullable = false, unique = true, length  = 55)
    @Email(message="email ist ungültig")
    private String email;

    // Profile picture field
    @Column
    private String profilBild;

    // Password field with validation constraints
    @NotBlank
    @Column(nullable = false)
    private String password;

    // Confirmed password field, not stored in the database
    @NotBlank
    @Transient
    private String confirmedPassword;

    // Many-to-many relationship with the Role entity
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();

}
