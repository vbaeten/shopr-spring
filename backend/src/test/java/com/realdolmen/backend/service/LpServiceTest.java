package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.enums.LpGenre;
import com.realdolmen.backend.repository.LpRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LpServiceTest {

    private Lp lp;

    @Mock
    private LpRepository lpRepository;

    @Mock
    private LpService lpService;

    @Before
    public void setUp() {
        lp = new Lp();
        lp.setPerformer("test");
        lp.setGenre(LpGenre.HIPHOP);
    }

//    @Test
//    public void testFindById() {
//        when(lpRepository.findById(anyLong())).thenReturn(Optional.of(lp.getId()));
//    }
}
