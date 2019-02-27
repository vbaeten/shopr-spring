package com.realdolmen.backend.facade;

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
}
