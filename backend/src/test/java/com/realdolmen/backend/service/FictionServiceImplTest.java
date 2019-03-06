package com.realdolmen.backend.service;

import com.realdolmen.backend.data.FictionTestDataBuilder;
import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.repository.FictionBookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class FictionServiceImplTest {

    @Mock
    private FictionBookRepository fictionBookRepository;
    @InjectMocks
    private FictionServiceImpl fictionService;

    private NonFiction nonFiction;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
        Fiction expectedFiction = FictionTestDataBuilder.buildFictionBook().build();

        when(fictionBookRepository.save(any())).thenReturn(expectedFiction);

        Fiction savedFiction = this.fictionBookRepository.save(expectedFiction);

        verify(fictionBookRepository, times(1)).save(expectedFiction);
        assertEquals(expectedFiction, savedFiction);
    }

    @Test
    public void findById() throws Exception {
        Fiction expectedFiction = FictionTestDataBuilder.buildFictionBook().build();
        when(fictionBookRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(expectedFiction));
        Fiction foundFiction = this.fictionService.findById(1L);

        verify(fictionBookRepository, times(1)).findById(1L);
        assertEquals(expectedFiction.getPrice(), foundFiction.getPrice(), 0.01);
    }

    @Test
    public void findAll() throws Exception {
        List<Fiction> expectedFictions = new ArrayList<>();
        Fiction fiction1 = FictionTestDataBuilder.buildFictionBook().build();
        expectedFictions.add(fiction1);

        when(fictionBookRepository.findAll()).thenReturn(expectedFictions);

        List<Fiction> actualFictions = this.fictionService.findAll();

        verify(fictionBookRepository, times(1)).findAll();
        assertEquals(expectedFictions.size(), actualFictions.size());
    }

    @Test
    public void delete() {
        Fiction fiction = FictionTestDataBuilder.buildFictionBook().build();
        fictionService.delete(fiction);

        verify(fictionBookRepository, times(1)).delete(fiction);
    }
}
