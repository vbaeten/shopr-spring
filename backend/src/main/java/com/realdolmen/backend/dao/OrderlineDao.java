package com.realdolmen.backend.dao;

import com.realdolmen.backend.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderlineDao extends JpaRepository<OrderLine, Long>
{


}
