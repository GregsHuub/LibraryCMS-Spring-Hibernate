package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}

