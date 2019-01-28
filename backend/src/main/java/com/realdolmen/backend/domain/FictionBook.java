package com.realdolmen.backend.domain;

import javax.persistence.*;
import java.io.Serializable;

@DiscriminatorValue("Fiction")
@Entity
@Table(name = "fiction")
public class FictionBook extends Book implements Serializable {

    @Column(name = "genre")
    @Enumerated
    private BookGenre bookGenre;
}
