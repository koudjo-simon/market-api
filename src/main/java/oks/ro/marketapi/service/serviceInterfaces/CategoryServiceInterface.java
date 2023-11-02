package oks.ro.marketapi.service.serviceInterfaces;

import oks.ro.marketapi.exceptions.CategoryNotFoundException;
import oks.ro.marketapi.model.Category;

import java.util.List;

public interface CategoryServiceInterface {
    List<Category> findCategories();
    Category findCategoryById(Long categoryId) throws CategoryNotFoundException;

    Category addCategory(Category category);
    Category updateCategory(Long categoryId, Category category) throws CategoryNotFoundException;
    void deleteCategoryById(Long categoryId) throws CategoryNotFoundException;
}
