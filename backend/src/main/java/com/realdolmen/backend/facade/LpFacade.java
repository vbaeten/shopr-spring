package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.mapper.LpMapper;
import com.realdolmen.backend.service.LpService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LpFacade {

    private final LpService lpService;
    private final LpMapper lpMapper;

    public LpFacade(LpService lpService, LpMapper lpMapper) {
        this.lpService = lpService;
        this.lpMapper = lpMapper;
    }

    public List<LpDto> findAll() {
        List<Lp> lps = lpService.findAll();
        return lps.stream().map(lpMapper::lpToLpDto).collect(Collectors.toList());
    }

    public LpDto findById(Long id) {
        Lp lp = lpService.findById(id);
        return lpMapper.lpToLpDto(lp);
    }

    public LpDto create(LpDto lpDto) {
        Lp lp = lpMapper.lpDtoToLp(lpDto);
        Lp savedLp = lpService.save(lp);
        return lpMapper.lpToLpDto(savedLp);
    }
}
