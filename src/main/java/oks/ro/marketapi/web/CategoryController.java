package oks.ro.marketapi.web;

import oks.ro.marketapi.exceptions.CategoryNotFoundException;
import oks.ro.marketapi.model.Category;
import oks.ro.marketapi.service.serviceInterfaces.CategoryServiceInterface;
import oks.ro.marketapi.web.webInterfaces.CategoryApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CategoryController implements CategoryApi {

    private final CategoryServiceInterface categoryServiceInterface;

    public CategoryController(CategoryServiceInterface categoryServiceInterface) {
        this.categoryServiceInterface = categoryServiceInterface;
    }

    @Override
    public List<Category> getCategories() {
        return categoryServiceInterface.findCategories();
    }

    @Override
    public Category getCategory(Long categoryId) throws CategoryNotFoundException {
        return categoryServiceInterface.findCategoryById(categoryId);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryServiceInterface.addCategory(category);
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) throws CategoryNotFoundException {
        return categoryServiceInterface.updateCategory(categoryId, category);
    }

    @Override
    public void deleteCategoryById(Long categoryId) throws CategoryNotFoundException {
        categoryServiceInterface.deleteCategoryById(categoryId);
    }
}
