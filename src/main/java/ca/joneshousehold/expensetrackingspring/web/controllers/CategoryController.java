package ca.joneshousehold.expensetrackingspring.web.controllers;

import ca.joneshousehold.expensetrackingspring.web.model.Category;
import ca.joneshousehold.expensetrackingspring.web.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API endpoints for resource: Categories.
 */
@RestController
@RequestMapping("api/v1/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping(value = "categories", method = RequestMethod.POST)
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.GET)
    public Category getCategory(@PathVariable String id) {
        return categoryService.getCategory(id);
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.PUT)
    public Category updateCategory(@PathVariable String id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.DELETE)
    public Category deleteCategory(@PathVariable String id) {
        return categoryService.archiveCategory(id);
    }
}
