package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Book extends Article implements Serializable {

    @Column
    @Size(max = 100)
    private String author;

    @Column
    @NotNull
    @Pattern(regexp="\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d")
    private long isbn;

    @Column
    private int pages;
}
