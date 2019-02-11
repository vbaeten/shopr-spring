package com.realdolmen.backend.Domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class Article extends BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Size(max = 100)
   @NotBlank
    private String title;

    @NotNull
    @Digits(integer = 6, fraction = 2)
    private Double price;

    @Size(max = 100)
    @NotBlank
    private String supplierId;

    @Column(insertable = false, updatable = false)
    private String type;

}
