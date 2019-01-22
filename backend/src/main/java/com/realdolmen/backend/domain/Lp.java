package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "lp")
public class Lp extends Product {

    private String performer;
}
