package com.realdolmen.shoprbackend.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("non-fiction book")
public class NonFiction extends Book{


    @Enumerated(EnumType.STRING)
    private Subject subject;





    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
