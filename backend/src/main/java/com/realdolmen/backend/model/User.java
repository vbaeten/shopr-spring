package com.realdolmen.backend.model;

import com.realdolmen.backend.model.enums.UserRoleEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Enumerated(EnumType.STRING)
    UserRoleEnum userRoleEnum;
    @ManyToMany
    private List<Rating> ratingList;
    @ManyToMany
    private List<Article> articleList;
    @Transient
    private String role;


}
