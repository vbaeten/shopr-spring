package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@DiscriminatorValue("Fiction")
@Entity
@Table(name = "fiction")
@Getter
@Setter
public class Fiction extends Book implements Serializable {

    @Column(name = "genre")
    @Enumerated
    private BookGenre bookGenre;

    @Column
    @Size(max = 255)
    private String synopsis;
}

