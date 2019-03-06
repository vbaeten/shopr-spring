package com.realdolmen.backend.facade;

import com.realdolmen.backend.data.FictionTestDataBuilder;
import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.mapper.FictionMapper;
import com.realdolmen.backend.service.FictionService;
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
public class FictionFacadeTest {


    @InjectMocks
    private FictionFacade fictionFacade;

    @Mock
    private FictionService fictionService;
    @Mock
    private FictionMapper fictionMapper;

    private Fiction fiction;
    private FictionDto fictionDto;



    @Before
    public void setUp() {
        fiction = FictionTestDataBuilder.buildFictionBook().build();
        fictionDto = FictionTestDataBuilder.buildFictionBookDto().build();
    }

    @Test
    public void findAll() {
        this.fictionFacade.findAll();
        verify(fictionService, times(1)).findAll();
    }

    @Test
    public void findById() {
        when(fictionService.findById(1L)).thenReturn(fiction);
        when(fictionMapper.fictionToFictionDto(fiction)).thenReturn(fictionDto);

        FictionDto fictionDtoResult;
        fictionDtoResult = fictionFacade.findById(1L);

        assertNotNull(fictionDtoResult);
        assertEquals(fiction.getPrice(), fictionDtoResult.getPrice(), 0.01);

        verify(fictionService, times(1)).findById(any());
    }

    @Test
    public void create() {
        fictionFacade.create(fictionDto);
        verify(fictionService, times(1)).save(any());
    }
}
