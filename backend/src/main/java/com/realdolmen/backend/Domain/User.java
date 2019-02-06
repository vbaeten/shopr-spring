package com.realdolmen.backend.Domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
public class User extends BaseObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String lastName;

    private String firstName;
    @Column(unique = true)
    @Size(max = 50)
    private String userName;

    private boolean loggedOn;

    private boolean admin;


}
