package com.realdolmen.shoprbackend.repository;

import com.realdolmen.shoprbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {



}
