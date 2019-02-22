package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shoppingcart")
@Data
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;

    @Column
    private int userId;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderLine> orderLines = new ArrayList<>();

}
