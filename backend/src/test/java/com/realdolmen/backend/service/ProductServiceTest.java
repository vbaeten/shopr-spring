package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.enums.LpGenre;
import com.realdolmen.backend.repository.ProductRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    private Lp lptoBeFoundById;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductService productService;

    @Before
    public void setUp() {
        lptoBeFoundById = new Lp();
        lptoBeFoundById.setGenre(LpGenre.HIPHOP);
        lptoBeFoundById.setPerformer("test");
    }



//    @Test
//    public void testFindById() {
//        when(productRepository.findById(anyLong())).thenReturn(Optional.of(lptoBeFoundById));
//
////        Lp lp = productRepository.findById(anyLong());
//        assertEquals(lptoBeFoundById, lp);
//    }
}
