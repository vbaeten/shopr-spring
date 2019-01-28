package com.realdolmen.backend.model;

import com.realdolmen.backend.model.enums.NonFictionGenreEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@DiscriminatorValue(value = "nonfiction")
public class NonFiction extends Book implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Enumerated(EnumType.STRING)
    NonFictionGenreEnum nonFictionGenreEnum;
    @Transient
    private String genre;
    private String about;




}
