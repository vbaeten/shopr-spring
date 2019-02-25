package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_order", updatable = false)
    private Date dateOfOrder;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean confirmed;

}
