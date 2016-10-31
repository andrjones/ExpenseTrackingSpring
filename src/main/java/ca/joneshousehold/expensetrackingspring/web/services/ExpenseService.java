package ca.joneshousehold.expensetrackingspring.web.services;

import ca.joneshousehold.expensetrackingspring.data.model.CategoryDAO;
import ca.joneshousehold.expensetrackingspring.data.model.ExpenseDAO;
import ca.joneshousehold.expensetrackingspring.data.repositories.CategoryRepository;
import ca.joneshousehold.expensetrackingspring.data.repositories.ExpenseRepository;
import ca.joneshousehold.expensetrackingspring.web.model.CategoryDTO;
import ca.joneshousehold.expensetrackingspring.web.model.ExpenseDTO;
import ca.joneshousehold.expensetrackingspring.web.model.ExpenseNotFoundException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Service for resource: Expenses.
 */
@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final DaoToDtoConverter daoToDtoConverter;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
        this.daoToDtoConverter = new DaoToDtoConverter();
    }

    @Transactional(readOnly = true)
    public List<ExpenseDTO> getExpenses() {
        List<ExpenseDAO> expenses = expenseRepository.findAll();
        return daoToDtoConverter.convertExpenseDAOCollection(expenses);
    }

    @Transactional(readOnly = true)
    public ExpenseDTO getExpense(String id) {
        ExpenseDAO expense = expenseRepository.findOne(id);
        if (expense != null) {
            return daoToDtoConverter.convertExpenseDao(expense);
        }
        throw new ExpenseNotFoundException(id);
    }

    @Transactional
    public ExpenseDTO createExpense(ExpenseDTO newExpense) {
        CategoryDAO cat = new CategoryDAO();
        cat.setId(newExpense.getCategory().getId());
        ExpenseDAO expense = new ExpenseDAO(
                cat, newExpense.getDate(), newExpense.getAmount(), newExpense.getPlace(), newExpense.getNote());
        ExpenseDAO saved = expenseRepository.save(expense);
        return daoToDtoConverter.convertExpenseDao(saved);
    }

    @Transactional
    public ExpenseDTO updateExpense(String id, ExpenseDTO updatedExpense) {
        ExpenseDAO expenseDAO = expenseRepository.findOne(id);
        if (expenseDAO != null) {
            CategoryDAO cat = new CategoryDAO();
            cat.setId(updatedExpense.getCategory().getId());
            expenseDAO.setDate(updatedExpense.getDate());
            expenseDAO.setAmount(updatedExpense.getAmount());
            expenseDAO.setNote(updatedExpense.getNote());
            expenseDAO.setPlace(updatedExpense.getPlace());
            ExpenseDAO saved = expenseRepository.save(expenseDAO);
            return daoToDtoConverter.convertExpenseDao(saved);
        }
        throw new ExpenseNotFoundException(id);
    }

    @Transactional
    public ExpenseDTO deleteExpense(String id) {
        ExpenseDAO expense = expenseRepository.findOne(id);
        if (expense != null) {
            ExpenseDTO expenseDTO = daoToDtoConverter.convertExpenseDao(expense);
            expenseRepository.delete(expense);
            return expenseDTO;
        }
        throw new ExpenseNotFoundException(id);
    }

    private ExpenseDTO getFakeExpense() {
        return new ExpenseDTO(
                "abc",
                new CategoryDTO("xyz", "test", "test"),
                new DateTime(1000, DateTimeZone.UTC),
                10.00,
                "miovision",
                "test");
    }
}
