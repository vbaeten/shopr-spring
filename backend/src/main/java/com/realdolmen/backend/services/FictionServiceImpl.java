package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.FictionDao;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.model.Fiction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FictionServiceImpl
{
private FictionDao fictionDao;

    public FictionServiceImpl(FictionDao fictionDao)
    {
        this.fictionDao = fictionDao;
    }

    public Fiction findById(Long id)
    {
        return fictionDao.findById(id).orElseThrow(() -> new NotFoundException("book not found"));
    }

    public List<Fiction> findAll()
    {
        return fictionDao.findAll();
    }

    public Fiction save(Fiction fiction)
    {

        return fictionDao.save(fiction);
    }}
