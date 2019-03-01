package com.realdolmen.backend.dto;

import lombok.*;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDto {

    private Long id;
    private int quantity;
    private double subTotal;
    private ArticleDto article;
    private OrderDto order;
    private UserDto user;

}
