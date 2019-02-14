package com.realdolmen.backend.Domain;

import com.realdolmen.backend.Domain.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "Orders")
@Entity
@Data
public class Order extends BaseObject {

    @Id
    @GeneratedValue
    private Long orderId;

    @OneToMany
    @JoinColumn(name = "orderId")
    private List<Orderline> orderlineList;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
