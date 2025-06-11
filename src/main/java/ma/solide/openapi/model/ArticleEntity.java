
package src.main.java.ma.solide.openapi.model;

import ma.solide.openAPI.model.Article;

import jakarta.persistence.*;

@Entity

public class ArticleEntity {

    @Id
    private Long id;

    private String name;

    // Constructor to convert from generated model
    public ArticleEntity(ma.solide.openAPI.model.Article dto) {
        this.id = dto.getId();
        this.name = dto.getName();
    }

    public Article toDto() {
        Article dto = new Article();
        dto.setId(id);
        dto.setName(name);
        return dto;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}