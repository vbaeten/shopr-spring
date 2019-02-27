package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.repository.FictionBookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FictionServiceImplTest {

    @Mock
    private FictionBookRepository fictionBookRepository;
    @InjectMocks
    private FictionServiceImpl fictionService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() throws Exception {
        List<Fiction> expectedFictions = Arrays.asList(
                new Fiction(),
                new Fiction()
        );

        when(fictionBookRepository.findAll()).thenReturn(expectedFictions);

        List<Fiction> actualFictions = fictionService.findAll();

        verify(fictionBookRepository, times(1)).findAll();
        assertEquals(expectedFictions.size(), actualFictions.size());
    }

    @Test
    public void delete() {
    }
}
