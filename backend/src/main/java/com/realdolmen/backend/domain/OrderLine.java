package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "order_line")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
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
