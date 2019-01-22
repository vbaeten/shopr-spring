package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "game")
public class Game extends Product {

    private String editor;
    private int pegiRating;
}
