package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Fiction
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

}
