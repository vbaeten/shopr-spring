package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderlineDto {
    private Long orderlineId;
    private Double subTotal;
    private Long quantity;
    private Article article;
    private Order order;
}
