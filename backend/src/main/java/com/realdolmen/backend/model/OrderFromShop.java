package com.realdolmen.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.realdolmen.backend.model.enums.OrderStateEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderFromShop implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;


    private Date orderDate;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private List<OrderLine> orderLines;

    @ManyToOne
    User user;

    @Enumerated(EnumType.STRING)
    private OrderStateEnum orderState;

    @Transient
    private Boolean paymentState;





}
