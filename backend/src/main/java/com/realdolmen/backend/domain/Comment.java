package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "comments")
public class Comment {


    @Id @GeneratedValue
    private Long id;

    @NotEmpty
    @Max(200) @Min(4)
    private String description;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;


}
