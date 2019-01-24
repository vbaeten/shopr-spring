package com.realdolmen.backend.dao;

import com.realdolmen.backend.model.Fiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FictionDao extends JpaRepository<Fiction, Long>
{


}
