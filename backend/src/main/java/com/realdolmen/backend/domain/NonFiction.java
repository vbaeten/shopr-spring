package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "nonFiction")
@DiscriminatorValue("nonFiction")
public class NonFiction extends Book {

    private String topic;
}
