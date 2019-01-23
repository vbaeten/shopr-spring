package com.realdolmen.shoprbackend.repository;


import com.realdolmen.shoprbackend.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {


}
