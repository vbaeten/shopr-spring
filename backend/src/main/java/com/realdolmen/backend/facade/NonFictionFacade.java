package com.realdolmen.backend.facade;

import com.realdolmen.backend.mapper.NonFictionMapper;
import com.realdolmen.backend.service.NonFictionService;
import org.springframework.stereotype.Component;

@Component
public class NonFictionFacade {

    private final NonFictionService nonFictionService;
    private final NonFictionMapper nonFictionMapper;

    public NonFictionFacade(NonFictionService nonFictionService, NonFictionMapper nonFictionMapper) {
        this.nonFictionService = nonFictionService;
        this.nonFictionMapper = nonFictionMapper;
    }
}
