package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void createArticle(Author author) {
        entityManager.persist(author);
    }
    public void updateBook(Author author) {
        entityManager.merge(author);
    }

    public void deleteBook(Author author) {
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }

    public List findAll() {
        Query query = entityManager.createQuery("SELECT b from Author b");
        return query.getResultList();
    }
}
