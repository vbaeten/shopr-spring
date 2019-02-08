package com.realdolmen.shoprbackend.repository;

import com.realdolmen.shoprbackend.domain.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine,Long> {

}
