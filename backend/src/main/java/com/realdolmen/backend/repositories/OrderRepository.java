package com.realdolmen.backend.repositories;

import com.realdolmen.backend.Domain.Order;
import com.realdolmen.backend.Domain.User;
import com.realdolmen.backend.Domain.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByUser(User user);

    Optional<Order> findByUserAndOrderStatus(User user, OrderStatus orderStatus);
}
