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
    private NonFictionBookRepository gameRepository;
    @InjectMocks
    private NonFictionServiceImpl fictionService;

    @Test
    public void save() {
        NonFiction expectedNonFiction = NonFictionTestDataBuilder.buildNonFictionBook().build();

        when(gameRepository.save(any())).thenReturn(expectedNonFiction);

        NonFiction savedNonFiction = this.gameRepository.save(expectedNonFiction);

        verify(gameRepository, times(1)).save(expectedNonFiction);
        assertEquals(expectedNonFiction, savedNonFiction);
    }

    @Test
    public void findById() {
        NonFiction expectedNonFiction = NonFictionTestDataBuilder.buildNonFictionBook().build();
        when(gameRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(expectedNonFiction));
        NonFiction foundNonFiction = this.fictionService.findById(1L);

        verify(gameRepository, times(1)).findById(1L);
        assertEquals(expectedNonFiction.getPrice(), foundNonFiction.getPrice(), 0.01);
    }

    @Test
    public void findAll() throws Exception {
        List<NonFiction> expectedNonFictions = new ArrayList<>();
        NonFiction fiction1 = NonFictionTestDataBuilder.buildNonFictionBook().build();
        expectedNonFictions.add(fiction1);

        when(gameRepository.findAll()).thenReturn(expectedNonFictions);

        List<NonFiction> actualNonFictions = fictionService.findAll();

        verify(gameRepository, times(1)).findAll();
        assertEquals(expectedNonFictions.size(), actualNonFictions.size());
    }

    @Test
    public void delete() {
        NonFiction nonFiction = NonFictionTestDataBuilder.buildNonFictionBook().build();
        fictionService.delete(nonFiction);

        verify(gameRepository, times(1)).delete(nonFiction);
    }
}
