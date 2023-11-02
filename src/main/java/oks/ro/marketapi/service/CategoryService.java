package oks.ro.marketapi.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import oks.ro.marketapi.exceptions.CategoryNotFoundException;
import oks.ro.marketapi.model.Category;
import oks.ro.marketapi.repository.CategoryRepository;
import oks.ro.marketapi.service.serviceInterfaces.CategoryServiceInterface;
import oks.ro.marketapi.service.service_utils.VerifyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CategoryService implements CategoryServiceInterface {

    private final CategoryRepository categoryRepository;
    private final VerifyEntity verifyEntity;

    public CategoryService(CategoryRepository categoryRepository, VerifyEntity verifyEntity) {
        this.categoryRepository = categoryRepository;
        this.verifyEntity = verifyEntity;
    }

    @Override
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long categoryId) throws CategoryNotFoundException {
        return verifyEntity.verifyCategory(categoryId);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) throws CategoryNotFoundException {
        Category findCategory = verifyEntity.verifyCategory(categoryId);
        category.setCategoryId(findCategory.getCategoryId());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long categoryId) throws CategoryNotFoundException {
        log.info("Deleting Category with id = "+categoryId);
        try {
            verifyEntity.verifyCategory(categoryId);
            categoryRepository.deleteById(categoryId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
