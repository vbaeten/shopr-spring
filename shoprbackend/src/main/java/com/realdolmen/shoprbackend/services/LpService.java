package com.realdolmen.shoprbackend.services;

import com.realdolmen.shoprbackend.domain.Lp;
import com.realdolmen.shoprbackend.exception.NotFoundException;
import com.realdolmen.shoprbackend.repository.LpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LpService implements CrudService<Lp,Long>  {

   private final LpRepository lpRepository;

    @Override
    public <S extends Lp> S save(S lp) {
        return lpRepository.save(lp);
    }

    @Override
    public Lp findById(Long id) {
        return lpRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Lp> findAll() {
        return lpRepository.findAll();
    }

    @Override
    public void delete(Lp lp) {

        lpRepository.delete(lp);
    }





    public LpService(LpRepository lpRepository) {
        this.lpRepository = lpRepository;
    }
}
