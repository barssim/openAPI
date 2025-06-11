package src.test.java.ma.solide.openAPI;

import ma.solide.openAPI.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import src.main.java.ma.solide.openapi.repository.ArticleRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class ArticleServiceTest {


    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testSaveArticle() {
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