package ma.solide.openapi.service;

import ma.solide.openAPI.model.ArticleDto;
import ma.solide.openapi.model.Article;
import ma.solide.openapi.model.ArticleMapper;
import ma.solide.openapi.repository.ArticleRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private ArticleService articleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveArticle() {
        // Given
        Article myArticle = new Article(4L, "AutoTeil");
        ArticleDto articleDto = ArticleMapper.toDto(Optional.of(myArticle));

        when(articleRepository.save(any(Article.class))).thenReturn(myArticle);

        ArticleDto savedArticle = articleService.createArticle(articleDto);

        assertEquals("AutoTeil", savedArticle.getName());
        verify(articleRepository, times(1)).save(any(Article.class));
    }

}
