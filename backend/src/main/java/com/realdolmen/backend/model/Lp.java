package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@DiscriminatorValue(value = "lp")
public class Lp implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotBlank
    private String artist;
    @Enumerated(EnumType.STRING)
    LpGenreEnum lpGenreEnum;


}
