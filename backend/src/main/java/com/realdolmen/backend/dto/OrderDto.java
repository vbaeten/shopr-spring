package com.realdolmen.backend.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Timestamp orderDate;
    private UserDto user;
    private List<OrderLineDto> orderLines = new ArrayList<>();
    private double total;
}
