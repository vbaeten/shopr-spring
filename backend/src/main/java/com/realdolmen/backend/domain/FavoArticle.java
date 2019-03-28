package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class FavoArticle extends BaseObject {

    @ManyToOne
    User user;

    @ManyToOne
    Article article;

    @Id
    @GeneratedValue
    private Long favoArticleId;
}
