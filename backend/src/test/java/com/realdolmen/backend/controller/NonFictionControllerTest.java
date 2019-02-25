package com.realdolmen.backend.controller;

import com.realdolmen.backend.service.NonFictionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class NonFictionControllerTest {

    @Mock
    NonFictionService nonFictionService;

    NonFictionController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new NonFictionController(nonFictionService);
    }

    @Test
    public void getNonFictionBooks() {
    }

    @Test
    public void addNonFiction() {
    }

    @Test
    public void getNonFiction() {
    }
}
