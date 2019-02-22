package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrdersByUserId(Long userId);

}
