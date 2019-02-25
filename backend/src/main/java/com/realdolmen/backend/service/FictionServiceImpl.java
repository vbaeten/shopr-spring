package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.repository.FictionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FictionServiceImpl implements FictionService {

    private FictionRepository fictionRepository;


    @Override
    public Fiction save(Fiction fiction) {
        return fictionRepository.save(fiction);
    }

    @Override
    public Fiction findById(Long id) {
        return fictionRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Fiction> findAll() {
        return fictionRepository.findAll();
    }

    @Override
    public void delete(Fiction fiction) {
        fictionRepository.delete(fiction);
    }
}
