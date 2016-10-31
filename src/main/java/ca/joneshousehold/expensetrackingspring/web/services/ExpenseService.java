package ca.joneshousehold.expensetrackingspring.web.services;

import ca.joneshousehold.expensetrackingspring.web.model.CategoryDTO;
import ca.joneshousehold.expensetrackingspring.web.model.ExpenseDTO;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Service for resource: Expenses.
 */
@Service
public class ExpenseService {

    public List<ExpenseDTO> getExpenses() {
        return Collections.singletonList(getFakeExpense());
    }

    public ExpenseDTO getExpense(String id) {
        return getFakeExpense();
    }

    public ExpenseDTO createExpense(ExpenseDTO newExpense) {
        return getFakeExpense();
    }

    public ExpenseDTO updateExpense(String id, ExpenseDTO updatedExpense) {
        return getFakeExpense();
    }

    public ExpenseDTO deleteExpense(String id) {
        return getFakeExpense();
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
