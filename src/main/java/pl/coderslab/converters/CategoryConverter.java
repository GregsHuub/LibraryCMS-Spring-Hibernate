package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Dao.CategoryDao;
import pl.coderslab.model.Category;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryDao categoryDao;

    public CategoryConverter(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public Category convert(String s) {
        return categoryDao.findById(Long.parseLong(s));
    }
}