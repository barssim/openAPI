package ma.solide.openapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.solide.openAPI.model.ArticleDto;
import ma.solide.openapi.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testGetProductByArtNo_ShouldReturnArticle() throws Exception {
        ArticleDto dto = new ArticleDto();
        dto.setId(1L);
        dto.setName("TestArticle");

        when(articleService.getArticle(1L)).thenReturn(dto);

        mockMvc.perform(get("/articles/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("TestArticle"));
    }
    @Test
    void testGetArticles_ShouldReturnAllArticles() throws Exception {
        ArticleDto dto1 = new ArticleDto();
        dto1.setId(1L);
        dto1.setName("Brake Pad");

        ArticleDto dto2 = new ArticleDto();
        dto2.setId(2L);
        dto2.setName("Oil Filter");

        when(articleService.findAllArticles()).thenReturn(
                List.of(
                        new ma.solide.openapi.model.Article(1L, "Brake Pad"),
                        new ma.solide.openapi.model.Article(2L, "Oil Filter")
                )
        );

        mockMvc.perform(get("/articles")) // adjust path if needed
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Brake Pad"));
    }

   // @Test
    void testCreateArticle() throws Exception {
        ArticleDto input = new ArticleDto();
        input.setName("TestArticle");

        ArticleDto saved = new ArticleDto();
        saved.setId(10L);
        saved.setName("TestArticle");

        when(articleService.createArticle(any(ArticleDto.class))).thenReturn(saved);

        mockMvc.perform(post("/articles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.name").value("TestArticle"));
    }
}
