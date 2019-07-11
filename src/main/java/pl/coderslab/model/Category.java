package pl.coderslab.model;

import org.hibernate.validator.constraints.Length;
import pl.coderslab.model.Article;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(min = 5)
    private String name;
    @Column(nullable = true)
    private String description;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER) // tego uzyc przy lazy initialization
    private Set<Article> articles = new HashSet<>();

    public Category() {
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        @Override
    public String toString() {
        return String.format("id: %s<br> name: %s <br>description: %s<br> articles: %s<br> ",
                id, name, description, articles);

    }
}
