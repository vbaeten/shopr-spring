package com.realdolmen.backend.controller;

import com.realdolmen.backend.data.ArticleTestDataBuilder;
import com.realdolmen.backend.dto.ArticleDto;
import com.realdolmen.backend.facade.ArticleFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerTest {

    @Mock
    ArticleFacade facade;

    @InjectMocks
    ArticleController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new ArticleController(facade);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getArticles() throws Exception {
        mockMvc.perform(get("/article/list"))
                .andExpect(status().isOk());

        verify(facade, times(1)).findArticles();
    }


    @Test
    public void getArticleById() throws Exception {

        ArticleDto articleDto = ArticleTestDataBuilder.buildArticleFictionBookDto().build();

        when(facade.findById(anyLong())).thenReturn(articleDto);

        mockMvc.perform(get("/article/1")).andExpect(status().isOk());

        verify(facade, times(1)).findById(anyLong());

    }

    @Test
    public void deleteUserById() throws Exception {
        mockMvc.perform(delete("/article/delete/1"))
                .andExpect(status()
                        .isOk());

        verify(facade, times(1)).deleteById(any());
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(delete("/article/delete"))
                .andExpect(status().isOk());

        verify(facade, times(1)).deleteArticle(any());
    }
}
