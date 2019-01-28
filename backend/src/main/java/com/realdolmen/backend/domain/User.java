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

    public User(String firstName, String name){
        this.firstName = firstName;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "first_name")
    private String firstName;



}
