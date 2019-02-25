package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "non_fiction")
@DiscriminatorValue("nonFiction")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NonFiction extends Book {

    @Enumerated(EnumType.STRING)
    @Column(name = "non_fiction_subject")
    private NonFictionSubject nonFictionSubject;


}
