package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@Entity
@Table(name = "user")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column
    private String name;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "user_name", unique = true, length = 100)
    private String userName;

    private boolean admin;
    private boolean loggedIn;

}
