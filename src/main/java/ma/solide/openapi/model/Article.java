
package ma.solide.openapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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