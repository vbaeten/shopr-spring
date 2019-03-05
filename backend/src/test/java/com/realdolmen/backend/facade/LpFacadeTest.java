package com.realdolmen.backend.facade;

import com.realdolmen.backend.data.LpTestDataBuilder;
import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.mapper.LpMapper;
import com.realdolmen.backend.service.LpService;
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
public class LpFacadeTest {


    @InjectMocks
    private LpFacade lpFacade;

    @Mock
    private LpService lpService;
    @Mock
    private LpMapper lpMapper;

    private Lp lp;
    private LpDto lpDto;



    @Before
    public void setUp() {
        lp = LpTestDataBuilder.buildLpHelloComputer().build();
        lpDto = LpTestDataBuilder.buildLpDtoHelloComputer().build();
    }

    @Test
    public void findAll() {
        this.lpFacade.findAll();
        verify(lpService, times(1)).findAll();
    }

    @Test
    public void findById() {
        when(lpService.findById(1L)).thenReturn(lp);
        when(lpMapper.lpToLpDto(lp)).thenReturn(lpDto);

        LpDto lpDtoResult;
        lpDtoResult = lpFacade.findById(1L);

        assertNotNull(lpDtoResult);
        assertEquals(lp.getPrice(), lpDtoResult.getPrice(), 0.01);

        verify(lpService, times(1)).findById(any());
    }

    @Test
    public void create() {
        lpFacade.create(lpDto);
        verify(lpService, times(1)).create(any());
    }
}
