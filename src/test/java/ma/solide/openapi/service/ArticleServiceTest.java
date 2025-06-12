package ma.solide.openapi.service;

import ma.solide.openapi.model.Article;
import ma.solide.openapi.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ArticleServiceTest {
    @Autowired
    private ArticleRepository articleRepository;


        @Test
        public void testSaveArticle () {
            // Create a new Article entity
            Article myArticle = new Article(4L, "AutoTeil");

            // Save the entity using the repository
            Article savedArticle = articleRepository.save(myArticle);

            // Verify that the savedArticle is not null and has an ID assigned
            assertNotNull(savedArticle.getId());

            // Verify that the savedArticle has the correct name
            assertEquals("AutoTeil", savedArticle.getName());
        }

}