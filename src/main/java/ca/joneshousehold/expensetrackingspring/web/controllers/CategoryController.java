package ca.joneshousehold.expensetrackingspring.web.controllers;

import ca.joneshousehold.expensetrackingspring.web.model.CategoryDTO;
import ca.joneshousehold.expensetrackingspring.web.model.CategoryNotFoundException;
import ca.joneshousehold.expensetrackingspring.web.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping(value = "categories", method = RequestMethod.POST)
    public CategoryDTO createCategory(@RequestBody CategoryDTO category) {
        return categoryService.createCategory(category);
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.GET)
    public CategoryDTO getCategory(@PathVariable String id) {
        return categoryService.getCategory(id);
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.PUT)
    public CategoryDTO updateCategory(@PathVariable String id, @RequestBody CategoryDTO category) {
        return categoryService.updateCategory(id, category);
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.DELETE)
    public CategoryDTO deleteCategory(@PathVariable String id) {
        return categoryService.archiveCategory(id);
    }
}
