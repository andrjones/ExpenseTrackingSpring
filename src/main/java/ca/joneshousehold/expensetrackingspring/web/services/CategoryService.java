package ca.joneshousehold.expensetrackingspring.web.services;

import ca.joneshousehold.expensetrackingspring.web.model.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * REST API endpoints for resource: Categories.
 */
@Service
public class CategoryService {

    public List<CategoryDTO> getCategories() {
        return Collections.singletonList(getFakeCategory());
    }

    public CategoryDTO getCategory(String id) {
        return getFakeCategory();
    }

    public CategoryDTO createCategory(CategoryDTO category) {
        return getFakeCategory();
    }

    public CategoryDTO updateCategory(String id, CategoryDTO category) {
        return getFakeCategory();
    }

    public CategoryDTO archiveCategory(String id) {
        return getFakeCategory();
    }

    private CategoryDTO getFakeCategory() {
        return new CategoryDTO("xyz", "test", "test");
    }
}
