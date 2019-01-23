package com.realdolmen.shoprbackend.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("non-fiction book")
@Table(name="non_fiction")
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
