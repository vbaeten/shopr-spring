package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    @Query(value= "SELECT o FROM OrderLine o WHERE o.user = :user ")
    List<OrderLine> findByUser(@Param("user") User user);

    @Query(value= "SELECT o FROM OrderLine o WHERE o.user.id = :id ")
    List<OrderLine> findByUserId(@Param("id") Long id);

    @Query(value= "SELECT o FROM OrderLine o WHERE o.user.id = :id AND o.order is null")
    List<OrderLine> findCurrentCartByUserId(@Param("id") Long id);

}
