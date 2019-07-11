package pl.coderslab.DTO;

import pl.coderslab.model.Category;
import pl.coderslab.model.Article;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class ArticleDto {

    // w dto robimy to samo co w Article zwyklym, ale przypisujemy do zmiennych taka wartosc jaka chcemy uzyskac
    // np. zeby content zwraacal content ale substring od 0 do 200 znakow maxymalnie


    private Long id;
    private String title;
    // to trzeba rozdzielac na name itp - AUTHOR
    private String authorFirstName;
    private String authorLastName;
    // to trzeba rozdzielac - CATEGORY
    private String categoryName;
    private String categoryDescription;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public ArticleDto() {
    }

    public ArticleDto(Article article) {

        this.id = article.getId();
        this.title = article.getTitle();
        this.authorFirstName = article.getAuthor().getFirstName();
        this.authorLastName = article.getAuthor().getLastName();
        this.categoryName = article.getCategories().stream()
                .map(category -> category.getName())
                .collect(Collectors.joining(", "));
        this.categoryDescription = article.getCategories().stream()
                .map(Category::getDescription)
                .collect(Collectors.joining(", "));
        this.content = article.getContent();
        this.createdOn = article.getCreatedOn();
        this.updatedOn = article.getUpdatedOn();
    }

    @PrePersist
    public void preCreatePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdated() {
        updatedOn = LocalDateTime.now();
    }

    public void shortenContent(int maxLength) { // metoda do skracania napisu;
        this.content = this.content.substring(0, Math.min(maxLength, this.content.length()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}

