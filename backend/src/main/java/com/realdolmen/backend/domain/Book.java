package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table
@DiscriminatorValue("book")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
abstract class Book extends Article{

    @Size(max = 100)
    @Column(name = "author")
    private String author;
    @NotNull
    @Column(name = "isbn", unique = true, length = 17)
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d{1}")
    private String isbn;
    @Column(name = "nr_of_pages")
    private int nrOfPages;
    @Column(insertable = false, updatable = false)
    private String bookType;

}
