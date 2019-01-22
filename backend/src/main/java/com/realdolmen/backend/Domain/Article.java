package com.realdolmen.backend.Domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
public abstract class Article extends BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Size(max = 100)
   @NotBlank
    private String title;

    @NotBlank
    @Digits(integer = 6, fraction = 2)
    private Double price;

    @Size(max = 100)
    @NotBlank
    private String supplierId;

    @Column(insertable = false, updatable = false)
    private String type;

}
