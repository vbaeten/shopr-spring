package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "non_fiction")
@DiscriminatorValue("nonFiction")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NonFiction extends Book {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "non_fiction_subject")
    private NonFictionSubject nonFictionSubject;


}
