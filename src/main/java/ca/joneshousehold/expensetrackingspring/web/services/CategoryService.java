package ca.joneshousehold.expensetrackingspring.web.services;

import ca.joneshousehold.expensetrackingspring.web.model.Category;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * REST API endpoints for resource: Categories.
 */
@Service
public class CategoryService {

    public List<Category> getCategories() {
        return Collections.singletonList(getFakeCategory());
    }

    public Category getCategory(String id) {
        return getFakeCategory();
    }

    public Category createCategory(Category category) {
        return getFakeCategory();
    }

    public Category updateCategory(String id, Category category) {
        return getFakeCategory();
    }

    public Category archiveCategory(String id) {
        return getFakeCategory();
    }

    private Category getFakeCategory() {
        return new Category("xyz", "test", "test");
    }
}
