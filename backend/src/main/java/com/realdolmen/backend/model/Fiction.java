package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@DiscriminatorValue(value = "fiction")
public class Fiction
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Size(max = 250)
    private String about;
    @Enumerated(EnumType.STRING)
    FictionGenreEnum fictionGenreEnum;

}
