
package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.domain.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService extends CrudService<Order, Long> {

    Order findById(Long id);

    void deleteById(Long id);

    List<Order> findAll();

    void saveOrderline(Order savedOrder, List<Orderline> persistedOrderlines, Orderline orderline);

    List<Order> findAllByUser(User user);

    Optional<Order> findByUserAndOrderStatus(User user, OrderStatus orderStatus);
}
