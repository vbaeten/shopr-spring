package com.realdolmen.backend.controller;

import com.realdolmen.backend.service.LpService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LpControllerTest {

    @Mock
    LpService lpService;

    LpController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new LpController(lpService);
    }

    @Test
    public void getLps() {
    }

    @Test
    public void addLp() {
    }

    @Test
    public void getLp() {
    }
}
