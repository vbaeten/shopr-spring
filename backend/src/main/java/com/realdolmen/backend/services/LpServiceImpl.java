package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.LpDao;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.model.Lp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LpServiceImpl
{
    private LpDao lpDao;

    public LpServiceImpl(LpDao lpDao)
    {
        this.lpDao = lpDao;
    }

    public Lp findById(Long id)
    {
        return lpDao.findById(id).orElseThrow(() -> new NotFoundException("lp not found"));
    }

    public List<Lp> findAll()
    {
        return lpDao.findAll();
    }

    public Lp save(Lp lp)
    {

        return lpDao.save(lp);
    }
}
