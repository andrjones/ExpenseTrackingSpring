package ca.joneshousehold.expensetrackingspring.web.services;

import ca.joneshousehold.expensetrackingspring.data.model.CategoryDAO;
import ca.joneshousehold.expensetrackingspring.data.model.ExpenseDAO;
import ca.joneshousehold.expensetrackingspring.web.model.CategoryDTO;
import ca.joneshousehold.expensetrackingspring.web.model.ExpenseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to convert between Data Access objects and Data Transfer objects.
 */
@Component
public class DaoToDtoConverter {

    public CategoryDTO convertCategoryDao(CategoryDAO categoryDAO) {
        return new CategoryDTO(
                categoryDAO.getId(),
                categoryDAO.getCategory(),
                categoryDAO.getSubcategory()
        );
    }

    public List<CategoryDTO> convertCategoryDaoCollection(List<CategoryDAO> categories) {
        return categories.stream().map(this::convertCategoryDao).collect(Collectors.toList());
    }

    public ExpenseDTO convertExpenseDao(ExpenseDAO expenseDAO) {
        return new ExpenseDTO(
                expenseDAO.getId(),
                convertCategoryDao(expenseDAO.getCategory()),
                expenseDAO.getDate(),
                expenseDAO.getAmount(),
                expenseDAO.getPlace(),
                expenseDAO.getNote()
        );
    }

    public List<ExpenseDTO> convertExpenseDAOCollection(List<ExpenseDAO> expenses) {
        return expenses.stream().map(this::convertExpenseDao).collect(Collectors.toList());
    }
}
