package com.realdolmen.shoprbackend.repository;

import com.realdolmen.shoprbackend.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
