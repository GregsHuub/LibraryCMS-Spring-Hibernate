package pl.coderslab.Dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void createArticle(Article article) {
        entityManager.persist(article);
    }
    public void updateBook(Article article) {
        entityManager.merge(article);
    }

    public void deleteBook(Article article) {
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }

//    public void findByIdFetch(Long id){
//        Author author = entityManager.find(Author.class, id);
//        Hibernate.initialize(author.getAuthors); // cos takiego ma byc
//
//    }

    public List findLast5() {
        Query query = entityManager.createQuery("SELECT b from Article b ORDER BY b.createdOn DESC");
        query.setMaxResults(5); // okreslamy ilosc do zwrocenia
        List<Article> resultList = query.getResultList();
        for (Article article : resultList) {
            Hibernate.initialize(article.getCategories());
        }
        return resultList;
    }
    public List<Article> findAll() {
        Query query = entityManager.createQuery("SELECT b from Article b");
        return query.getResultList();
    }

    public Article findById(Long id){
        return entityManager.find(Article.class, id);
    }

//    public List z5podPkt2(){
//        Query query = entityManager.createQuery(SELECT )
//    }


}
