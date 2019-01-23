package com.realdolmen.backend.dao;

import com.realdolmen.backend.model.Lp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LpDao extends JpaRepository<Lp, Long>
{


}
