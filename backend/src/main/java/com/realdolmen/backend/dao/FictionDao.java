package com.realdolmen.backend.dao;

import com.realdolmen.backend.model.Fiction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FictionDao extends JpaRepository<Fiction, Long>
{


}
