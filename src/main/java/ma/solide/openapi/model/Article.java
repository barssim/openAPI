
package ma.solide.openapi.model;

import jakarta.persistence.*;

@Entity
public class Article {

    @Id
    private Long id;

    private String name;

    public Article(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Article() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}