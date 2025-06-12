package ma.solide.openapi.service;

import ma.solide.openAPI.model.ArticleDto;
import ma.solide.openapi.model.ArticleMapper;
import ma.solide.openapi.repository.ArticleRepository;
import ma.solide.openapi.model.Article;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDto getArticle(Long id) {
        Optional<Article>  article = articleRepository.findById(id);
        return ArticleMapper.toDto(article);
    }

    public ArticleDto createArticle(ArticleDto dto) {
        Article article = ArticleMapper.toEntity(dto);
        article = articleRepository.save(article);
        return ArticleMapper.toDto(Optional.of(article));
    }

    public  List<Article> findAllArticles()
    {
        return articleRepository.findAll();
    }
}
