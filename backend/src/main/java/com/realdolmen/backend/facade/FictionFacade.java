package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.mapper.FictionMapper;
import com.realdolmen.backend.service.FictionService;
import org.springframework.stereotype.Component;

@Component
public class FictionFacade {

    private final FictionService fictionService;
    private final FictionMapper fictionMapper;

    public FictionFacade(FictionService fictionService, FictionMapper fictionMapper) {
        this.fictionService = fictionService;
        this.fictionMapper = fictionMapper;
    }

    public FictionDto create(FictionDto fictionDto) {
        Fiction fiction = fictionMapper.fictionDtoToFiction(fictionDto);
        Fiction savedFiction = fictionService.create(fiction);
        return fictionMapper.fictionToFictionDto(savedFiction);
    }
}
