package com.realdolmen.backend.service;

import com.realdolmen.backend.data.NonFictionTestDataBuilder;
import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.repository.NonFictionBookRepository;
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
public class NonFictionServiceImplTest {

    @Mock
    private NonFictionBookRepository nonFictionRepository;
    @InjectMocks
    private NonFictionServiceImpl nonFictionService;

    @Test
    public void save() {
        NonFiction expectedNonFiction = NonFictionTestDataBuilder.buildNonFictionBook().build();

        when(nonFictionRepository.save(any())).thenReturn(expectedNonFiction);

        NonFiction savedNonFiction = this.nonFictionService.save(expectedNonFiction);

        verify(nonFictionRepository, times(1)).save(expectedNonFiction);
        assertEquals(expectedNonFiction, savedNonFiction);
    }

    @Test
    public void findById() {
        NonFiction expectedNonFiction = NonFictionTestDataBuilder.buildNonFictionBook().build();
        when(nonFictionRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(expectedNonFiction));
        NonFiction foundNonFiction = this.nonFictionService.findById(1L);

        verify(nonFictionRepository, times(1)).findById(1L);
        assertEquals(expectedNonFiction.getPrice(), foundNonFiction.getPrice(), 0.01);
    }

    @Test
    public void findAll() throws Exception {
        List<NonFiction> expectedNonFictions = new ArrayList<>();
        NonFiction fiction1 = NonFictionTestDataBuilder.buildNonFictionBook().build();
        expectedNonFictions.add(fiction1);

        when(nonFictionRepository.findAll()).thenReturn(expectedNonFictions);

        List<NonFiction> actualNonFictions = nonFictionService.findAll();

        verify(nonFictionRepository, times(1)).findAll();
        assertEquals(expectedNonFictions.size(), actualNonFictions.size());
    }

    @Test
    public void delete() {
        NonFiction nonFiction = NonFictionTestDataBuilder.buildNonFictionBook().build();
        nonFictionService.delete(nonFiction);

        verify(nonFictionRepository, times(1)).delete(nonFiction);
    }
}
