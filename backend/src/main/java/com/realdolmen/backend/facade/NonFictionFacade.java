package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;
import com.realdolmen.backend.mapper.NonFictionMapper;
import com.realdolmen.backend.service.NonFictionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NonFictionFacade {

    private final NonFictionService nonFictionService;
    private final NonFictionMapper nonFictionMapper;

    public NonFictionFacade(NonFictionService nonFictionService, NonFictionMapper nonFictionMapper) {
        this.nonFictionService = nonFictionService;
        this.nonFictionMapper = nonFictionMapper;
    }

    public List<NonFictionDto> findAll() {
        List<NonFiction> nonFictions = nonFictionService.findAll();
        return nonFictions.stream().map(nonFictionMapper::nonFictionToNonFictionDto).collect(Collectors.toList());
    }

    public NonFictionDto findById(Long id) {
        NonFiction nonFiction = nonFictionService.findById(id);
        return nonFictionMapper.nonFictionToNonFictionDto(nonFiction);
    }

    public NonFictionDto create(NonFictionDto nonFictionDto) {
        NonFiction nonFiction = nonFictionMapper.nonFictionDtoToFiction(nonFictionDto);
        NonFiction savedNonFiction = nonFictionService.save(nonFiction);
        return nonFictionMapper.nonFictionToNonFictionDto(savedNonFiction);
    }
}
