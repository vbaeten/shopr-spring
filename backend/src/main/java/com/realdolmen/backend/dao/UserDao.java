package com.realdolmen.backend.dao;

import com.realdolmen.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long>
{

    User findOneByLastName(String name);

}
