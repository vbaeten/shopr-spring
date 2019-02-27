package com.realdolmen.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderLineDto {


    private Long id;
    private int quantity;
    private double subTotal;
    private ArticleDto articleDto;
    private OrderDto orderDto;
    private UserDto userDto;

}
