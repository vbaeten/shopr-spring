package com.realdolmen.backend.dao;

import com.realdolmen.backend.model.OrderFromShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderFromShopDao extends JpaRepository<OrderFromShop, Long>
{



}
