package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.NonFictionDao;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.model.NonFiction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonFictionServiceImpl
{

    private NonFictionDao nonFictionDao;

    public NonFictionServiceImpl(NonFictionDao nonFictionDao)
    {
        this.nonFictionDao = nonFictionDao;
    }

    public NonFiction findById(Long id)
    {
        return nonFictionDao.findById(id).orElseThrow(() -> new NotFoundException("book not found"));
    }

    public List<NonFiction> findAll()
    {
        return nonFictionDao.findAll();
    }

    public NonFiction save(NonFiction nonFiction)
    {

        return nonFictionDao.save(nonFiction);
    }
}
