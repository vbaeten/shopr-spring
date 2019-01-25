package com.realdolmen.shoprbackend.services;

import com.realdolmen.shoprbackend.domain.NonFiction;
import com.realdolmen.shoprbackend.exception.NotFoundException;
import com.realdolmen.shoprbackend.repository.NonFictionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonFictionService implements CrudService<NonFiction,Long> {


    private final NonFictionRepository nonFictionRepository;



    @Override
    public <S extends NonFiction> S save(S entity) {
        return nonFictionRepository.save(entity);
    }

    @Override
    public NonFiction findById(Long primaryKey) {
        return nonFictionRepository.findById(primaryKey)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<NonFiction> findAll() {
        return nonFictionRepository.findAll();
    }

    @Override
    public void delete(NonFiction entity) {

        nonFictionRepository.delete(entity);
    }


    public NonFictionService(NonFictionRepository nonFictionRepository) {
        this.nonFictionRepository = nonFictionRepository;
    }
}
