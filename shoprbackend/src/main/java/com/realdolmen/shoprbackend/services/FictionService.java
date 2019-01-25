package com.realdolmen.shoprbackend.services;


import com.realdolmen.shoprbackend.domain.Fiction;
import com.realdolmen.shoprbackend.exception.NotFoundException;
import com.realdolmen.shoprbackend.repository.FictionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FictionService implements CrudService<Fiction,Long> {



    private final FictionRepository fictionRepository;



    @Override
    public <S extends Fiction> S save(S entity) {
        return fictionRepository.save(entity);
    }

    @Override
    public Fiction findById(Long primaryKey) {
        return fictionRepository.findById(primaryKey)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Fiction> findAll() {
        return fictionRepository.findAll();
    }

    @Override
    public void delete(Fiction entity) {
        fictionRepository.delete(entity);

    }


    public FictionService(FictionRepository fictionRepository) {
        this.fictionRepository = fictionRepository;
    }
}
