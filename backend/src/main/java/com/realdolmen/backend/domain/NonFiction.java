package com.realdolmen.backend.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "non_fiction")
@DiscriminatorValue("Non-Fiction")
public class NonFiction extends Book implements Serializable {

    @Column
    private Subject subject;
}
