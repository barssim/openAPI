package src.main.java.ma.solide.openapi.service;

import src.main.java.ma.solide.openapi.model.ArticleEntity;
import src.main.java.ma.solide.openapi.repository.ArticleRepository;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<ArticleEntity> list() {
        return articleRepository.findAll();
    }
}
