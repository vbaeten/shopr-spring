package com.realdolmen.backend.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@DiscriminatorValue("Fiction")
@Entity
@Table(name = "fiction")
public class FictionBook extends Book implements Serializable {

    @Column
    private BookGenre bookGenre;
}
