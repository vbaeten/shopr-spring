package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
    @Size(max = 100)
    private String name;
    @NotNull
    @Column(name = "first_name")
    @Size(max = 100)
    private String firstName;
    @NotNull
    @Column(name = "user_name", unique = true, length = 30)
    @Size(min = 3, max = 30)
    private String userName;

    private boolean admin;

}
