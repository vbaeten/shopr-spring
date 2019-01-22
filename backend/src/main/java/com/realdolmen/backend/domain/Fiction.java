package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "fiction")
@DiscriminatorValue("fiction")
public class Fiction extends Book {

    private String summary;
}
