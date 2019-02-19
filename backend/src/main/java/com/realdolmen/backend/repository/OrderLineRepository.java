package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findOrderLineByOrderOrderId(Long orderId);
}
