package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table
@DiscriminatorValue("fiction")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Fiction extends Book {

    @Size(max = 255)
    @Column(name = "short_summary")
    private String shortSummary;

    @Enumerated(EnumType.STRING)
    @Column(name = "fiction_genre")
    private FictionGenre fictionGenre;

}
