package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {


    @PersistenceContext
    private EntityManager entityManager;


    public void createCategory(Category category){
        entityManager.persist(category);
    }

    public void updateCategory(Category category){
        entityManager.merge(category);
    }
    public Category deleteCategory(Category category){
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
        return category;
    }

    public Category findById(Long id){
        return entityManager.find(Category.class, id);
    }


    public List<Category> showAll(){
        Query query = entityManager.createQuery("SELECT b FROM Category b");

        return query.getResultList();
    }







//wyświetlić listę wszystkich kategorii
//dodać kategorię
//usunąć kategorię
//edytować kategorię
}


