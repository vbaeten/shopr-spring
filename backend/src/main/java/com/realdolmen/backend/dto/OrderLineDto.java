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
    private ArticleDto articleDto;
    private OrderDto orderDto;
    private UserDto userDto;

}
