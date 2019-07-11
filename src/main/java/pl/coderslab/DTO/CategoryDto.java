package pl.coderslab.DTO;

import pl.coderslab.model.Category;

import java.util.stream.Collectors;

public class CategoryDto {

    private Long id;
    private String name;
    private String description;
    private String article;


    public CategoryDto(){

    }

    public CategoryDto(Category category){

        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
        this.article = category.getArticles().stream().map(article -> article.getTitle())
                .collect(Collectors.joining(", "));

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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
