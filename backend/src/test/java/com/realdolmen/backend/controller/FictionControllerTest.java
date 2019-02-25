package com.realdolmen.backend.controller;

import com.realdolmen.backend.service.FictionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FictionControllerTest {

    @Mock
    FictionService fictionService;

    FictionController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new FictionController(fictionService);
    }

    @Test
    public void getFictionBooks() {
    }

    @Test
    public void addFiction() {
    }

    @Test
    public void getFiction() {
    }
}
