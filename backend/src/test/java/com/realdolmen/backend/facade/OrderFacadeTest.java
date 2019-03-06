package com.realdolmen.backend.facade;

import com.realdolmen.backend.data.OrderTestDataBuilder;
import com.realdolmen.backend.data.UserTestDataBuilder;
import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.mapper.OrderMapper;
import com.realdolmen.backend.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderFacadeTest {

    @InjectMocks
    private OrderFacade orderFacade;

    @Mock
    private OrderService orderService;
    @Mock
    private OrderMapper orderMapper;

    private Order order;

    @Before
    public void setUp() {
        order = OrderTestDataBuilder.buildOrder1().build();
    }

    @Test
    public void findOrdersByUser() {

        User user = UserTestDataBuilder.buildUserBernadetteSanz().build();
        orderFacade.findOrdersByUser(anyLong());

        verify(orderService, times(1)).findByUserId(anyLong());
    }

    @Test
    public void save() {
        OrderDto orderDto = OrderTestDataBuilder.buildOrderDto1().build();
        UserDto userDto = UserTestDataBuilder.buildUserDtoBernadetteSanz().build();
        orderFacade.save(orderDto, userDto);

        verify(orderService, times(1)).save(any());
    }
}
