package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderLineDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineMapper {

    OrderLineDto OrderLineToOrderLineDto(OrderLine orderLine);
    OrderLine OrderLineDtoToOrderLine(OrderLineDto orderLineDto);

}
