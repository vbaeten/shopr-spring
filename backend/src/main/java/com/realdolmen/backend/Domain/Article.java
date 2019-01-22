package com.realdolmen.backend.Domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
public abstract class Article extends BaseObject {
   @Size(max = 100)
   @NotBlank
    private String title;
    @NotBlank
    @Digits(integer = 6, fraction = 2)
    private Double price;

    private String supplierId;

    @Column(insertable = false, updatable = false)
    private String type;

}
