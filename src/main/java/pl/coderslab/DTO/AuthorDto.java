package pl.coderslab.DTO;

import pl.coderslab.model.Author;

import java.util.stream.Collectors;

public class AuthorDto {


    private Long id;
    private String firstName;
    private String lastName;
    private String article;

    public AuthorDto() {
    }

    public AuthorDto(Author author){
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.article = author.getArticles().stream().map(article -> article.getTitle())
                .collect(Collectors.joining(", "));

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
