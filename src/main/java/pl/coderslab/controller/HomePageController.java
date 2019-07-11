package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Article;
import pl.coderslab.Dao.ArticleDao;
import pl.coderslab.DTO.ArticleDto;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/article")
public class HomePageController {

    public ArticleDao articleDao;



    @Autowired
    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;

    }

    //    @RequestMapping("/create")
//    @ResponseBody
//    public String createSomeArticle(){ // to zrobic tak aby z jsp pobieralo dane(z formularza)
//        Article article1 = new Article();
//
//        article1.setId(2L);
//
//        article1.setContent("SomeContentForTest1");
//        article1.setTitle("Jakis tytul artykulu1");
//        article1.setUpdatedOn(LocalDateTime.now());
//        article1.setCreatedOn(LocalDateTime.now());
//
//        articleDao.createArticle(article1);
//
//
//        return "redirect:http://localhost:8080/api/article/showArticle/2";
//    }


    @RequestMapping("/showFiveArticle")
    @ResponseBody
    public String showAll() {

        List fiveArticles = articleDao.findLast5();



        return "list of articcles: " + fiveArticles;
    }

    @RequestMapping("/200") // wyswietlanei 200 znakow z tytulem i data
    @ResponseBody
    public String show200(@ModelAttribute ArticleDto articleDto){

        List<Article> all = articleDao.findLast5();

        List<ArticleDto> dtoList = all.stream()
                .map(ArticleDto::new)
                .peek(articleDto1 -> articleDto1.shortenContent(200))
                .collect(Collectors.toList());


        return "" + dtoList.stream().map(dto -> String.join(" | ", dto.getTitle(), dto.getContent(),
                dto.getCreatedOn().toString())).collect(Collectors.joining("<br><br>"));

    }


    // przy pobieraniu artykulow zrobic liste posortowana po created, i wtedy pobrac DESC?
    // subList(0,5) 5 pozycji i to beda te pozycje






}
