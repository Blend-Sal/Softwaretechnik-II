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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

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

    @Column(nullable = false, unique = true, length  = 55)
    @Email(message="email ist ungültig")
    private String email;

    @Column
    private String profilBild;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Transient
    private String confirmedPassword;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();

}