package ca.joneshousehold.expensetrackingspring.web.services;

import ca.joneshousehold.expensetrackingspring.web.model.Category;
import ca.joneshousehold.expensetrackingspring.web.model.Expense;
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

    public List<Expense> getExpenses() {
        return Collections.singletonList(getFakeExpense());
    }

    public Expense getExpense(String id) {
        return getFakeExpense();
    }

    public Expense createExpense(Expense newExpense) {
        return getFakeExpense();
    }

    public Expense updateExpense(String id, Expense updatedExpense) {
        return getFakeExpense();
    }

    public Expense deleteExpense(String id) {
        return getFakeExpense();
    }

    private Expense getFakeExpense() {
        return new Expense(
                "abc",
                new Category("xyz", "test", "test"),
                new DateTime(1000, DateTimeZone.UTC),
                10.00,
                "miovision",
                "test");
    }
}
