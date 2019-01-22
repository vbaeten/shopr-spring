package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.STRING;

@Entity
@Data
@DiscriminatorColumn(discriminatorType = STRING , name = "type")
public class Article
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;


}
