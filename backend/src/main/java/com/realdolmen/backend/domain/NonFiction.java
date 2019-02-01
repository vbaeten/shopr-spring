package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "non_fiction")
@DiscriminatorValue("nonFiction")
public class NonFiction extends Book{

    @Enumerated(EnumType.STRING)
    @Column(name = "non_fiction_subject")
    private NonFictionSubject nonFictionSubject;


}
