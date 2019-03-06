package com.realdolmen.backend.facade;

import com.realdolmen.backend.data.NonFictionTestDataBuilder;
import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;
import com.realdolmen.backend.mapper.NonFictionMapper;
import com.realdolmen.backend.service.NonFictionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NonFictionFacadeTest {

    @InjectMocks
    private NonFictionFacade nonFictionFacade;

    @Mock
    private NonFictionService nonFictionService;
    @Mock
    private NonFictionMapper nonFictionMapper;

    private NonFiction nonFiction;
    private NonFictionDto nonFictionDto;



    @Before
    public void setUp() {
        nonFiction = NonFictionTestDataBuilder.buildNonFictionBook().build();
        nonFictionDto = NonFictionTestDataBuilder.buildNonFictionBookDto().build();
    }

    @Test
    public void findAll() {
        this.nonFictionFacade.findAll();
        verify(nonFictionService, times(1)).findAll();
    }

    @Test
    public void findById() {
        when(nonFictionService.findById(1L)).thenReturn(nonFiction);
        when(nonFictionMapper.nonFictionToNonFictionDto(nonFiction)).thenReturn(nonFictionDto);

        NonFictionDto nonFictionDtoResult;
        nonFictionDtoResult = nonFictionFacade.findById(1L);

        assertNotNull(nonFictionDtoResult);
        assertEquals(nonFiction.getPrice(), nonFictionDtoResult.getPrice(), 0.01);

        verify(nonFictionService, times(1)).findById(any());
    }

    @Test
    public void create() {
        nonFictionFacade.create(nonFictionDto);
        verify(nonFictionService, times(1)).save(any());
    }
}
