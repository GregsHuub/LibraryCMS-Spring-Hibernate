package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Dao.CategoryDao;
import pl.coderslab.model.Category;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/category")
public class CategoryController {

    public CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
// PANEL OGÓLNY

    @RequestMapping("/panel")
    public String mainPanel(Model model){
        model.addAttribute("id",0);

        return "mainPanelCategory_view";
    }

    // POKAZUJE WSZYSTKO
    @RequestMapping("/showAll") // wsywietla wszystko
    @ResponseBody
    public String showALl(){


        List<Category> categories = categoryDao.showAll();
        return "list of categories: <br> " + categories;
    }
// USUWANIE
    @RequestMapping("/delete") // dziala, usuwa po ID
    @ResponseBody
    public String delete(@RequestParam Long id){

        Category foundById = categoryDao.findById(id);
        Category categoryTODelete = categoryDao.deleteCategory(foundById);
        return "usunieta kategoria: " + categoryTODelete;
    }

// EDYTOWANIE - widok
    @GetMapping("/edit")
    public String edit(@RequestParam long id, Model model){

        model.addAttribute("id", id);
        Category category = categoryDao.findById(id);
        model.addAttribute("category", category);
        return "edit_category";
    }

// EDYTOWANIE - dzialanie
    @RequestMapping("/editCategoryPost")
    @ResponseBody
    public String editPost(Category category){

        Category existCategory = categoryDao.findById(category.getId());
        existCategory.setDescription(category.getDescription());
        existCategory.setName(category.getName());
        categoryDao.updateCategory(existCategory);

        return "Edit sie udal";
//        return "udalo sie"; // tutaj ma byc przekierowanie do widoku display_category
    }







}
