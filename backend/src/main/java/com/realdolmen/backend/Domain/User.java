package com.realdolmen.backend.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
public class User extends BaseObject {

    @Id
    @GeneratedValue
    private Long userId;

    private String lastName;

    private String firstName;
    @Column(unique = true)
    @Size(max = 50)
    private String userName;

    private boolean admin;

//    @OneToMany(mappedBy = "")
//    private List<Order> orderList;
}
