package ma.solide.openapi.controller;

import ma.solide.openAPI.api.ArticlesApi;
import ma.solide.openAPI.model.ArticleDto;
import ma.solide.openapi.model.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ma.solide.openapi.service.ArticleService;

import java.util.List;

@RestController
public class ArticleController implements ArticlesApi {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ResponseEntity<ArticleDto> getProductByArtNo(Integer artNo) {
        if (artNo == null || artNo <= 0) {
            return ResponseEntity.notFound().build();
        }

        ArticleDto articleDto = articleService.getArticle(Long.valueOf(artNo));

        return ResponseEntity.ok(articleDto);
    }

    @Override
    public ResponseEntity<List<ArticleDto>> getArticles(Integer limit) {
        List<Article> articles = articleService.findAllArticles();

        return ResponseEntity.ok(articles.stream().map(article -> {
            ArticleDto dto = new ArticleDto();
            dto.setId(article.getId());
            dto.setName(article.getName());
            return dto;
        }).toList());

    }

    @Override
    public ResponseEntity<ArticleDto> createArticle(ArticleDto articleDto) {
        ArticleDto savedArticle = articleService.createArticle(articleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
}

