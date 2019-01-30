package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
public class User {

    @Id @GeneratedValue
    private Long id;

//    @Column(nullable = false, unique = true)
    private String username;
//    @NotEmpty
    private String firstname;
//    @NotEmpty
    private String lastname;

    @Size(min = 4)
    private String password;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
