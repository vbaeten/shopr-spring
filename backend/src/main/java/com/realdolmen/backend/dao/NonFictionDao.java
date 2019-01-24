package com.realdolmen.backend.dao;

import com.realdolmen.backend.model.NonFiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonFictionDao extends JpaRepository<NonFiction, Long>
{


}
