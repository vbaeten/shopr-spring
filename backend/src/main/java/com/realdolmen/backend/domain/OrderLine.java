package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "order_line")
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "article_id", referencedColumnName = "article_id")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    @Transient
    private BigDecimal subTotal;


}
