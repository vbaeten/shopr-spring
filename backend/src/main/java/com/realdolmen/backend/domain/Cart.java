package com.realdolmen.backend.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "cart")
//@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content=JsonInclude.Include.NON_EMPTY)
public class Cart {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String  id;

//    @OneToOne @MapsId
//    private User user;

    // Bidirectionnal
//    @Column(name = "cart_user_id")
//    private Long userId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    private double totalPrice;

}
