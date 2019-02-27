package com.realdolmen.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Long id;
    private Timestamp orderDate;
    private UserDto userDto;
    private List<OrderLineDto> orderLines = new ArrayList<>();
    private double total;
}
