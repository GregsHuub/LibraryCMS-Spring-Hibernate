package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.DTO.CategoryDto;
import pl.coderslab.model.Category;
import pl.coderslab.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<CategoryDto> showAll(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(CategoryDto::new)
                .collect(Collectors.toList());

    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void delete(Category category){
        categoryRepository.save(category);
    }
    public Category findByOne(Long id) {
        return categoryRepository.findOne(id);

    }
}
