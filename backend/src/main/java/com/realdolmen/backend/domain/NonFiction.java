package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "non_fiction")
@DiscriminatorValue("nonFiction")
@AllArgsConstructor
@NoArgsConstructor
public class NonFiction extends Book{

    @Enumerated(EnumType.STRING)
    @Column(name = "non_fiction_subject")
    private NonFictionSubject nonFictionSubject;


}
