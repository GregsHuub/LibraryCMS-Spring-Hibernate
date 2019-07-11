package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.DTO.ArticleDto;
import pl.coderslab.DTO.CategoryDto;
import pl.coderslab.model.Article;
import pl.coderslab.model.Category;
import pl.coderslab.repositories.ArticleRepository;
import pl.coderslab.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ArticleService {

    private ArticleRepository articleRepository;


    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public List<ArticleDto> showAll(){
        List<Article> articleList = articleRepository.findAll();
        return articleList.stream()
                .map(ArticleDto::new)
                .collect(Collectors.toList());

    }

    public void save(Article article) {
        articleRepository.save(article);
    }

    public void delete(Article article){
        articleRepository.save(article);
    }
    public Article findByOne(Long id) {
        return articleRepository.findOne(id);

    }
}
