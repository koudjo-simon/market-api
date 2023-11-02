package oks.ro.marketapi.web.webInterfaces;

import oks.ro.marketapi.exceptions.CategoryNotFoundException;
import oks.ro.marketapi.model.Category;
import oks.ro.marketapi.web.webInterfaces.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
public interface CategoryApi {
    String URL = "/category";
    String ID = "/{categoryId}";

    @GetMapping(Constants.BASE_URL + URL + "/list")
    List<Category> getCategories();

    @GetMapping(Constants.BASE_URL + URL + ID)
    Category getCategory(@PathVariable Long categoryId) throws CategoryNotFoundException;

    @PostMapping(Constants.BASE_URL + URL + "/add")
    Category addCategory(@RequestBody Category category);

    @PutMapping(Constants.BASE_URL + URL + ID + "/update")
    Category updateCategory(@PathVariable Long categoryId, @RequestBody Category category) throws CategoryNotFoundException;

    @DeleteMapping(Constants.BASE_URL + URL + ID + "/delete")
    void deleteCategoryById(@PathVariable Long categoryId) throws CategoryNotFoundException;
}
