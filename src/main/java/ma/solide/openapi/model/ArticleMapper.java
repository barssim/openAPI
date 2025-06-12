package ma.solide.openapi.model;

import ma.solide.openAPI.model.ArticleDto;
import java.util.Optional;

public class ArticleMapper {

    private ArticleMapper() {
    }

    public static ArticleDto toDto(Optional<Article> optionalArticle) {
        if (optionalArticle.isEmpty()) {
            return null; // or throw exception depending on your design
        }

        Article article = optionalArticle.get();
        return new ArticleDto(
                article.getId(),
                article.getName()
        );
    }

    public static Article toEntity(ArticleDto dto) {
        if (dto == null) return null;
        return new Article(
                dto.getId(),
                dto.getName()
        );
    }


}
