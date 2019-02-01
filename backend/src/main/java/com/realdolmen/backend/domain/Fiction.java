package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table
@DiscriminatorValue("fiction")
public class Fiction extends Book{

    @Size(max = 255)
    @Column(name = "short_summary")
    private String shortSummary;

    @Enumerated(EnumType.STRING)
    @Column(name = "fiction_genre")
    private FictionGenre fictionGenre;

}
