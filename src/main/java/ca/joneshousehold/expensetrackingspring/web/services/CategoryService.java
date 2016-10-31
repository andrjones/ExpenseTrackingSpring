package ca.joneshousehold.expensetrackingspring.web.services;

import ca.joneshousehold.expensetrackingspring.data.model.CategoryDAO;
import ca.joneshousehold.expensetrackingspring.data.repositories.CategoryRepository;
import ca.joneshousehold.expensetrackingspring.web.model.CategoryDTO;
import ca.joneshousehold.expensetrackingspring.web.model.CategoryNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * REST API endpoints for resource: Categories.
 */
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final DaoToDtoConverter daoToDtoConverter;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.daoToDtoConverter = new DaoToDtoConverter();
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> getCategories() {
        List<CategoryDAO> categories = categoryRepository.findAll();
        return daoToDtoConverter.convertCategoryDaoCollection(categories);
    }

    @Transactional(readOnly = true)
    public CategoryDTO getCategory(String id) {
        CategoryDAO category = categoryRepository.findOne(id);
        if (category != null) {
            return daoToDtoConverter.convertCategoryDao(category);
        }
        throw new CategoryNotFoundException(id);
    }

    @Transactional
    public CategoryDTO createCategory(CategoryDTO category) {
        CategoryDAO categoryDAO = new CategoryDAO(category.getCategory(), category.getSubCategory());
        CategoryDAO saved = categoryRepository.save(categoryDAO);
        return daoToDtoConverter.convertCategoryDao(saved);
    }

    @Transactional
    public CategoryDTO updateCategory(String id, CategoryDTO category) {
        CategoryDAO categoryDAO = categoryRepository.findOne(id);
        if (categoryDAO != null) {
            categoryDAO.setCategory(category.getCategory());
            categoryDAO.setSubcategory(category.getSubCategory());
            CategoryDAO saved = categoryRepository.save(categoryDAO);
            return daoToDtoConverter.convertCategoryDao(saved);
        }
        throw new CategoryNotFoundException(id);
    }

    @Transactional
    public CategoryDTO archiveCategory(String id) {
        CategoryDAO categoryDAO = categoryRepository.findOne(id);
        if (categoryDAO != null) {
            categoryDAO.setActive(false);
            CategoryDAO saved = categoryRepository.save(categoryDAO);
            return daoToDtoConverter.convertCategoryDao(saved);
        }
        throw new CategoryNotFoundException(id);
    }

}
