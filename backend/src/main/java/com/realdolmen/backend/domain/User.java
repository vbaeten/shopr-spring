package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name = "user")
@EqualsAndHashCode
@NoArgsConstructor
public class User{

    public User(String firstName, String name, boolean isAdmin){
        this.firstName = firstName;
        this.name = name;
        this.isAdmin = isAdmin;
        this.isLoggedIn = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column
    private String name;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "is_admin")
    private boolean isAdmin;
    private boolean isLoggedIn;



}
