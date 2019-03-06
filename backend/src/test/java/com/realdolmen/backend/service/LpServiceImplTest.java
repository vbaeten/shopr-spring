package com.realdolmen.backend.service;

import com.realdolmen.backend.data.LpTestDataBuilder;
import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.repository.LpRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LpServiceImplTest {
    @Mock
    private LpRepository lpRepository;
    @InjectMocks
    private LpServiceImpl lpService;

    @Test
    public void save() {
        Lp expectedLp = LpTestDataBuilder.buildLpHelloComputer().build();

        when(lpRepository.save(any())).thenReturn(expectedLp);

        Lp savedLp = this.lpService.save(expectedLp);

        verify(lpRepository, times(1)).save(expectedLp);
        assertEquals(expectedLp, savedLp);
    }

    @Test
    public void findById() {
        Lp expectedLp = LpTestDataBuilder.buildLpHelloComputer().build();
        when(lpRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(expectedLp));
        Lp foundLp = this.lpService.findById(1L);

        verify(lpRepository, times(1)).findById(1L);
        assertEquals(expectedLp.getPrice(), foundLp.getPrice(), 0.01);
    }

    @Test
    public void findAll() throws Exception {
        List<Lp> expectedLps = new ArrayList<>();
        Lp lp1 = LpTestDataBuilder.buildLpHelloComputer().build();
        expectedLps.add(lp1);

        when(lpRepository.findAll()).thenReturn(expectedLps);

        List<Lp> actualLps = lpService.findAll();

        verify(lpRepository, times(1)).findAll();
        assertEquals(expectedLps.size(), actualLps.size());
    }

    @Test
    public void delete() {
        Lp lp = LpTestDataBuilder.buildLpHelloComputer().build();
        lpService.delete(lp);

        verify(lpRepository, times(1)).delete(lp);
    }
}
