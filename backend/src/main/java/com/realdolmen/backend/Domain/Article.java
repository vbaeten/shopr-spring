package com.realdolmen.backend.Domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Article extends BaseObject {

    private Double price;

    private String title;

    private String supplierId;


}
