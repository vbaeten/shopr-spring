package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.mapper.LpMapper;
import com.realdolmen.backend.service.LpService;
import org.springframework.stereotype.Component;

@Component
public class LpFacade {

    private final LpService lpService;
    private final LpMapper lpMapper;

    public LpFacade(LpService lpService, LpMapper lpMapper) {
        this.lpService = lpService;
        this.lpMapper = lpMapper;
    }

    public LpDto create(LpDto lpDto) {
        Lp lp = lpMapper.lpDtoToLp(lpDto);
        Lp savedLp = lpService.create(lp);
        return lpMapper.lpToLpDto(savedLp);
    }
}
