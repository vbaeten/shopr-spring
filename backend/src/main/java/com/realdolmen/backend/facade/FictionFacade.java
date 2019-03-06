package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.mapper.FictionMapper;
import com.realdolmen.backend.service.FictionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FictionFacade {

    private final FictionService fictionService;
    private final FictionMapper fictionMapper;

    public FictionFacade(FictionService fictionService, FictionMapper fictionMapper) {
        this.fictionService = fictionService;
        this.fictionMapper = fictionMapper;
    }

    public List<FictionDto> findAll() {
        List<Fiction> fictions = fictionService.findAll();
        return fictions.stream().map(fictionMapper::fictionToFictionDto).collect(Collectors.toList());
     }

    public FictionDto findById(Long id) {
        Fiction fiction = fictionService.findById(id);
        return fictionMapper.fictionToFictionDto(fiction);
    }

    public FictionDto create(FictionDto fictionDto) {
        Fiction fiction = fictionMapper.fictionDtoToFiction(fictionDto);
        Fiction savedFiction = fictionService.save(fiction);
        return fictionMapper.fictionToFictionDto(savedFiction);
    }
}
