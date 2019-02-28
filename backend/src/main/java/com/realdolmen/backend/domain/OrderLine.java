package com.realdolmen.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "order_line")
@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int quantity;

    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @JsonIgnore
    @ManyToOne
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
